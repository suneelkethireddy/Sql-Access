package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example2StudentsFromDatabase {
	public Connection con;
	public Statement stmt;
	public static Example2StudentsFromDatabase db;
	private Example2StudentsFromDatabase(){
		String url="jdbc:mysql://localhost:3306/";
		String dbName="student";
		String driver="com.mysql.jdbc.Driver";
		String userName="root";
		String password="root";
		try{
			Class.forName(driver).newInstance();
			this.con=(Connection)DriverManager.getConnection(url+dbName,userName,password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	}
