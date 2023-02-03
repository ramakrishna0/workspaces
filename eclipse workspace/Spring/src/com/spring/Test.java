package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDao;
import com.model.Employee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Resource resource = new ClassPathResource("applicationContext.xml");
		 * BeanFactory factory = new XmlBeanFactory(resource);
		 * Student s = (Student) factory.getBean("studentbean");
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student s = (Student) context.getBean("studentNew");
		System.out.println(s);
		
		A a = context.getBean("A", A.class);
		a.display();
		
		EmployeeDao dao=(EmployeeDao)context.getBean("edao");  
	    int status=dao.saveEmployee(new Employee(104,"Amit",35000));  
	    System.out.println(status); 
	    
	    /*int status=dao.updateEmployee(new Employee(102,"Sonoo",15000)); 
	    System.out.println(status); 
	    */  
	          
	    /*Employee e=new Employee(); 
	    e.setId(102); 
	    int status=dao.deleteEmployee(e); 
	    System.out.println(status);*/  
		
	}

}
