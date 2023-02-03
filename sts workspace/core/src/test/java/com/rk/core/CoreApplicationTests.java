package com.rk.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rk.core.dao.PaymentDAO;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CoreApplicationTests {
	
	@Autowired
	private PaymentDAO service;
	
	@Test
	void testDependencyInjection() {
		assertNotNull(service);
	}

}
