package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class TestConnection {

	public static void main(String[] args) {
		

		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Loaded driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			System.out.println("Connected to MySql");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			ResultSetMetaData metadata=(ResultSetMetaData) rs.getMetaData();
			int columncount=metadata.getColumnCount();
			//rs.last();
			List<Student> studentList=new ArrayList<Student>();
			while(rs.next()){
				/*
				Student student=new Student();
				student.setPhone(rs.getInt("studentPhone"));
				student.setId(rs.getInt("studentId"));
				student.setName(rs.getString("studentName"));
				student.setAddress(rs.getString("studentAddress"));
				studentList.add(student);
				*/
			}
				//studentList.add( rs.getContent());	}
			System.out.println(studentList);

			/*ResultSetMetaData rsmd=(ResultSetMetaData)rs.getMetaData();

			System.out.println(rsmd);

			int numberOfColumns=rsmd.getColumnCount();
			for(int i=1;i<=numberOfColumns;i++){
				if(i>1) System.out.print(", ");
				String columnValue=rs.getString(i);
				System.out.println(columnValue);
			}
			System.out.println(" ");
			while(rs.next()){
				for (int i = 1; i <= numberOfColumns; i++) {
					if (i > 1) System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
				}
				System.out.println("");  
			}*/
			stmt.close();
			con.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
