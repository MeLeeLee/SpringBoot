package com.melelee.springboot.bean.mybatis;

import java.util.List;


public interface HospitalMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Hospital record);

	int insertSelective(Hospital record);

	Hospital selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Hospital record);

	int updateByPrimaryKey(Hospital record);

	List<Hospital> findAll();

}