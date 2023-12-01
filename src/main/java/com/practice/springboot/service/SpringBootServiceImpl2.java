package com.practice.springboot.service;

import org.springframework.stereotype.Service;

@Service("SpringBootServiceImpl2")
public class SpringBootServiceImpl2 implements SpringBootService {

	@Override
	public String getMessage() {
		return "From SpringBootServiceImpl2";
	}

}
