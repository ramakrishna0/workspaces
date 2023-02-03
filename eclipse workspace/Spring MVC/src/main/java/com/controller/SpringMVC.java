package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVC {
	
	@RequestMapping("/")
	public String display() {
		return "index";
	}
}
