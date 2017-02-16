package com.montyhall.infrastructure;

import javax.inject.Named;

import com.montyhall.domain.HelloWorldDomainService;

@Named
public class HelloWorldDaoServiceImpl implements HelloWorldDaoService {

	@Override
	public String getMessage() {
		String message = "Hello, World!";
		return message;
	}

}
