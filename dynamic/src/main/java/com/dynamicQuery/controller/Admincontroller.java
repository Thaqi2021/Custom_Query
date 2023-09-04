package com.dynamicQuery.controller;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamicQuery.DynamicApplication;
import com.dynamicQuery.customQuery.EmpCustomQuery;
import com.dynamicQuery.dto.EmpShortInfo;
import com.dynamicQuery.model.Employee;
import com.dynamicQuery.repository.EmpRepository;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/api")
@RestController
public class Admincontroller {
	
	@Autowired
	EmpRepository emprepo;
	
	@Autowired
	EmpCustomQuery ecq;
	
	@GetMapping(value = "/done")
    public String test(HttpServletRequest request) {
		Employee emp= new Employee();
		emp.setId(3);
		emp.setAge("23");
		emp.setExpense("3000");
		emp.setName("Praveen");
		emp.setDesig("software");
		emp.setDate(new Date());
		emp.setMobno(9879879870L);
		emprepo.save(emp);
		System.out.println("success");
		
		
		return "success";
	}
	
	@GetMapping(value = "/pro")
    public String process(HttpServletRequest request) {
		Employee emp= new Employee();
		emp.setAge("21");
		emp.setExpense("1000");
		emp.setName("shankar");
		emp.setDesig("software");
		List<EmpShortInfo> petinfo = ecq.Petinfo(emp);
		System.out.println(petinfo.get(0).getMobno());
		System.out.println(petinfo.get(0).getDesig());
		System.out.println(petinfo.get(0).getName());
		System.out.println(petinfo.get(0).getDate());

		System.out.println("success");
		return "success";
	}

	
	
}
