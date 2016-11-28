package com.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExample {
	public static Connection con;

	public static void main(String[] args) {
		try{
			connectionQuery();
			PreparedStatement statement=con.prepareStatement("SELECT * from student");
			ResultSet result=statement.executeQuery();
			System.out.println("DataBase table accessed");
			while(result.next()){
				String retrievedid=result.getString("Column_name");
				System.out.println(retrievedid);
			}
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
	}
	public static void connectionQuery(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307//suneel","root","root");
			System.out.println("Remote DB connection established");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
			
		}
		catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Remote server could not be connected");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Remote db connection established error");
		}
		
	}

}
