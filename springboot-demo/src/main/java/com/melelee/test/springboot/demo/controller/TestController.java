package com.melelee.test.springboot.demo.controller;

import com.google.zxing.WriterException;
import com.melelee.test.springboot.demo.configuration.Author;
import com.melelee.test.springboot.demo.entity.User;
import com.melelee.test.springboot.demo.job.AsyncJob;
import com.melelee.test.springboot.demo.qrcode.QRCodeFactory;
import com.melelee.test.springboot.demo.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * 测试
 *
 * @author mengll
 * @create 2018-02-02 14:57
 **/
@RestController
public class TestController {

	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	private TestService testService;

	@Autowired
	Author author;

	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int id) {
		return testService.getUser(id);
	}

	@PostMapping("/insert")
	public int getUser(@RequestBody User user) {
		user.setRegTime(new Date().toString());
		return testService.saveUser(user);
	}

	@GetMapping("/getAuthor")
	public Author getAuthor() {
		Author returnAuthor = new Author();
		BeanUtils.copyProperties(author,returnAuthor);
		return returnAuthor;
	}

	@PostMapping("/exception")
	public int exception() {
		return 1/0;
	}

	@GetMapping("/testRedis")
	public String testRedis(){
		stringRedisTemplate.opsForValue().set("name","mengll");
		return stringRedisTemplate.opsForValue().get("name");
	}

	@Autowired
	AsyncJob asyncJob;
	@GetMapping("/async")
	public String async(){
		asyncJob.job1();
		asyncJob.job2();
		asyncJob.job3();
		return "success";
	}


	@GetMapping("/generateQRcode")
	public void generateQRcode(@RequestParam(value = "msg") String msg,HttpServletResponse res) throws IOException, WriterException {

		String logUri = "/root/qrcode/source.png";
		String outFileUri = "/root/qrcode/qrCode.png";
		int[] size = new int[]{430, 430};
		String format = "jpg";
		new QRCodeFactory().CreatQrImage(msg, format, outFileUri, logUri, size);

		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=qrCode.png");
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File(outFileUri)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (bis != null) {
				bis.close();
			}
		}
	}
}
