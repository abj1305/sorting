package com.practice.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.service.SpringBootService;

import io.micrometer.common.lang.Nullable;

@RestController
public class SpringBootController {

	@Qualifier("SpringBootServiceImpl1")
	@Autowired
	private SpringBootService springBootService1;
	
	@Qualifier("SpringBootServiceImpl2")
	@Autowired
	private SpringBootService springBootService2;
	
	@GetMapping(value = "/apiTest")
	public ResponseEntity<String> apiTest1(@RequestParam @Nullable String type) throws Exception {
		String response ;
		if("1".equals(type)) {
			response =  springBootService1.getMessage();
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		if("2".equals(type)) {
			response =  springBootService2.getMessage();	
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid Type", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
