package com.montyhall.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.montyhall.infrastructure.HelloWorldDaoServiceImpl;

@Named
public class HelloWorldDomainServiceImpl implements HelloWorldDomainService {

	@Inject
	HelloWorldDaoServiceImpl helloWorldDaoServiceImpl;
	
	@Override
	public String getMessage() {
		String message = helloWorldDaoServiceImpl.getMessage();
		return message;
	}

}
