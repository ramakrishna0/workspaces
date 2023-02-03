package com.rk.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.thymeleaf.model.Student;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Nothing to display");
		
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("rama");
		student.setScore(100);
		mav.addObject("student", student);
		System.out.println(student);
		return mav;
	}

	@RequestMapping("/getstudents")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		List<Student> students = new ArrayList<>();
		for(int i=0; i<5; i++) {
			Student s = new Student();
			s.setName("rama" + (i+1));
			s.setScore(100);
			students.add(s);
		}
		mav.addObject("students", students);
		return mav;
	}
}
