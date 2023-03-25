package com.example.sybaseConnection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sybaseConnection.database.DbConnection;
import com.example.sybaseConnection.entity.Student;

@Service
public class DbServices {

	
@Autowired
DbConnection dbConnection;


public void insertData(Student student) throws Exception {
	
	
	Connection connection=dbConnection.db();
	 // Statement createStatement=connection.createStatement();
	 
	 // System.out.println(createStatement.execute("insert into Student(stuname,age) values('mukesh',42)"));
	//  System.out.println( createStatement.execute("insert into Student(stuname,age) values('Ramya',42)", Statement.RETURN_GENERATED_KEYS ));
	  
	PreparedStatement prepareStatement=connection.prepareStatement("insert into Student(stuname,age) values(?,?)");
	 
	prepareStatement.setNString(1, student.getName());
	prepareStatement.setInt(2, student.getAge());
	prepareStatement.executeUpdate() ;
//	  createStatement.addBatch("insert into Student(stuname,age) values('dinesh',25)" );
//	  createStatement.addBatch("insert into Student(stuname,age) values('mahesh',24)");
//	  
	
}

public List searchData(int age)throws Exception {
	
	List<Student> list=new ArrayList() ;
	Student st=new Student() ;
	Connection connection=dbConnection.db();
	PreparedStatement prepareStatement=connection.prepareStatement("select * from  Student where age=?");
	 prepareStatement.setInt(1,age );
	ResultSet  resultSet=prepareStatement.executeQuery() ;
	while(resultSet.next()) {
		st.setName(resultSet.getNString("stuname"));
		 st.setAge(resultSet.getInt("age"));	
		 list.add(st);
	}
	 
	 return list;
	
}

}
