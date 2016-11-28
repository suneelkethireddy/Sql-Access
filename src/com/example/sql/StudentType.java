package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;

public class StudentType {
	static Statement stmt=null;
	static Connection conn = null;
	static ResultSet rs=null;
	public static boolean insertStudents(Student student)throws Exception
	{
		List<Student> list=new ArrayList<Student>();
		Statement stmt = conn.createStatement();
		

				return true;
	}
	public static void main(String[] args) throws Exception {
		conn=getDBConnection();
		Student student=new Student();
		System.out.println(insertStudents(student));

	}
	public static Connection getDBConnection()throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
