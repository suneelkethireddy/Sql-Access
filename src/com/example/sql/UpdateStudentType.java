package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.example.model.Student;

public class UpdateStudentType 
{
	public boolean insertQuery(Student student){

		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="root";
		try{
			Connection con=DriverManager.getConnection(url,user,password);

			Statement stmt=con.createStatement();

			String sql="insert into student"+
					"(studentId,studentName,studentPhone,studentAddress)"+
					" values (id,name,phone,address)";
			int rowsModified=stmt.executeUpdate(sql);
			System.out.println(rowsModified);


		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}

