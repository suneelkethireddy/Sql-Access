package com.example.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsingIterator {
	static Statement stmt=null;
	static Connection conn = null;
	static ResultSet rs=null;
	public static Connection getDBConnection()throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static void insertIntoDB(){
		try {
			Statement stmt = conn.createStatement();
			String sql="insert into student"+
					"(studentId,studentName,studentPhone,studentAddress)"+
					" values (19523,'Ranjith Tellakula',35125,'DixonLanding')";
			int rowsModified=stmt.executeUpdate(sql);
			System.out.println(rowsModified);
		} catch(Exception e){
			e.printStackTrace();
		}
		}
	public static void main(String args[]) throws Exception{
		conn=getDBConnection();
		insertIntoDB();
	}
}