package com.practice.springboot.service;

import org.springframework.stereotype.Service;

@Service("SpringBootServiceImpl1")
public class SpringBootServiceImpl1 implements SpringBootService {

	@Override
	public String getMessage() {
		return "From SpringBootServiceImpl1";
	}

}
