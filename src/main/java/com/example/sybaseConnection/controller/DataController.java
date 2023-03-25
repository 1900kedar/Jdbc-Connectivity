package com.example.sybaseConnection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sybaseConnection.dao.DbServices;
import com.example.sybaseConnection.entity.Student;

@RestController
public class DataController {
	
	@Autowired
	DbServices dbServices;
	@PostMapping("/home")
	public ResponseEntity<String> record(@RequestParam("name") String name,@RequestParam("rollno") int rollno) throws Exception{
		
		ResponseEntity<String> rs=new ResponseEntity<String>("sucess fully getting data", HttpStatus.OK) ;
		Student st=new Student();
		 st.setName(name);
		 st.setAge(rollno);
		dbServices.insertData(st);
		return rs ;
	}
	
	@PostMapping("/search")
	public List search(@RequestParam("age") int age) throws Exception{
		
		
		return dbServices.searchData(age);
		
	}
}
