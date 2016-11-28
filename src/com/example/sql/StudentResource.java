package com.example.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;
public class StudentResource {
	static Statement stmt=null;
	static Connection conn = null;
	static ResultSet rs=null;
	public static void main(String[] args) throws Exception
	{	
 		conn = getDBConnection();
		//System.out.println(getStudent(15618));
		Student student=new Student(15618,"sunee1111",81060);
		//System.out.println(insertQuery(student));
		System.out.println(updateStudent(student));
		//System.out.println(getAllStudents());
		//System.out.println(deleteStudent(1235));
	}
	public static Student updateStudent(Student student) throws Exception{


		Student currentStudent = getStudent(student.getId());
		int studentId = currentStudent.getId();
		String studentName = (student.getName()==null)?currentStudent.getName():student.getName();
		String studentAddress=(student.getAddress()==null)?currentStudent.getAddress():student.getAddress();
		int studentPhone=(student.getPhone()== 0)?currentStudent.getPhone():student.getPhone();

		String insertQuery = "Update student SET studentName=?,studentPhone=?,studentAddress=? WHERE studentId=?";
		java.sql.PreparedStatement ps = conn.prepareStatement(insertQuery);		
		ps.setString(1, studentName);
		ps.setInt(2, studentPhone);
		ps.setString(3, studentAddress);
		ps.setInt(4, studentId);
		ps.execute();
		Student updatedStudentRecord = getStudent(studentId);
		System.out.println(updatedStudentRecord);
		return updatedStudentRecord;
	}
	public static  List<Student> getAllStudents(Student student)throws Exception
	{
		List<Student> list=new ArrayList<Student>();
		Statement stmt = conn.createStatement();

		try {
			rs = stmt.executeQuery("select * from student");
			while(rs.next()){

				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setPhone(rs.getInt(3));
				student.setAddress(rs.getString(4));
				//list.add("\n");
				list.add(student);		}
			System.out.print(list);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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

	public static void closeDBConnection()throws Exception{
		try {
			if(conn!=null)
				conn.close();

		}catch(Exception e){
			e.printStackTrace();

		}
	}
	/**
	 * This method returns a student record
	 * corresponding to the studentId
	 * @param studentId
	 * @param stmt 
	 * @return 
	 * @return Student Object
	 * @throws SQLException 
	 */
	public static Student  getStudent(int studentId)throws Exception
	{
		try {
			conn= getDBConnection();
			Statement stmt=conn.createStatement();
			Student student=new Student(studentId);
			String sql=("select * from student where studentId="+studentId);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				student.setId(rs.getInt("studentId"));
				student.setPhone(rs.getInt("studentPhone"));
				student.setAddress(rs.getString("studentAddress"));
				student.setName(rs.getString("studentName"));
			}
			return student;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * This method deletes a student record from 
	 * the table for a given studentId
	 * @param studentId
	 * @return
	 */
	public static boolean deleteStudent(int studentId)
	{
		int count=0;
		int count1=0;
		try {
			conn= getDBConnection();
			Statement stmt=conn.createStatement();

			ResultSet rs1=stmt.executeQuery("SELECT * from student");
			while(rs.next()){
				count++;
			}
			String sql=("DELETE * from student where studentId="+studentId);
			stmt.executeUpdate(sql);
			ResultSet rs2=stmt.executeQuery("SELECT * FROM student");
			if(rs.next()){
				count1++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(count==count1)
			return true;
		else
			return false;
	}
	/**
	 * This method deletes all student records from DB
	 * @return
	 */
	public boolean deleteAllStudents()
	{
		return true;
	}
	public static boolean insertQuery(Student student){


		try{


			//Statement stmt=con.createStatement();
			String insertQuery = "insert into student (studentId,studentName,studentPhone,studentAddress) values (?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			return (pstmt.executeUpdate()==1);



		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}
}
