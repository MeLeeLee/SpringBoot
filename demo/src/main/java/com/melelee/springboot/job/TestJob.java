package com.melelee.springboot.job;

import com.alibaba.fastjson.JSONObject;
import com.melelee.springboot.bean.Hospital;
import com.melelee.springboot.bean.HospitalMapper;
import com.melelee.springboot.bean.Organization;
import com.melelee.springboot.bean.OrganizationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-06 15:54
 **/
@Component
@Slf4j
public class TestJob {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	HospitalMapper hospitalMapper;
	@Autowired
	OrganizationMapper organizationMapper;

	@Scheduled(cron = "${cronExpression}")
	public void doSomeThing() throws Exception {
		log.info("定时任务执行：{}", new Date());
		List<Hospital> hospitalList = hospitalMapper.findAll();
		for (Hospital hospital : hospitalList){
			String latitude = hospital.getLatitude();
			String longitude = hospital.getLongitude();
			String msg = restTemplate.getForObject(
					"http://api.map.baidu.com/geocoder/v2/" +
							"?callback=renderReverse" +
							"&location="+latitude+","+longitude +
							"&output=json" +
							"&pois=1" +
							"&ak=xp6KyzCSoMq24YX6YDN6osck6WBTa9hO",String.class);
			msg = msg.replace("renderReverse&&renderReverse(","");
			msg = msg.substring(0,msg.length()-1);
			JSONObject jsonObject = JSONObject.parseObject(msg);
			if (jsonObject.getInteger("status")==0){
				jsonObject = jsonObject.getJSONObject("result").getJSONObject("addressComponent");
				String province = jsonObject.getString("province");
				String city = jsonObject.getString("city");
				String district = jsonObject.getString("district");
				Organization organization = new Organization();
				organization.setId(UUID.randomUUID().toString());
				organization.setName(hospital.getHospitalName());
				organization.setCode(hospital.getLocationCode()+"01");
				organization.setProvince(province);
				organization.setCity(city);
				organization.setDistrict(district);
				organization.setStatus(1);
				organization.setCreateTime(new Date());
				organizationMapper.insert(organization);
			}else {
				throw new Exception("查询百度借口异常");
			}
		}
		log.info("结束");
	}
}
