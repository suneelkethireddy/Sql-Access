package com.example.model;

public class Student {
	private int phone;
	private int id;
	private String name;
	private String address;
	private String query;
	
	public Student(int id){
		this.id=id;
	}
	public Student(int id, int phone, String address, String name){
		this.id=id;
		this.phone=phone;
		this.address=address;
		this.name=name;
	}
	public Student(){
		
	}
public Student(int id,String name,String address){
	this.id=id;
	this.name=name;
	this.address=address;
}
public Student(int id,String address,int phone){
	this.id=id;
	this.phone=phone;
	this.address=address;
}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [phone=" + phone + ", id=" + id + ", name=" + name
				+ ", address=" + address + "]";
	}
	public void updateQuerey(){
		 query = " insert into users (studentId , studentName, studentPhone, studentAddress)"
		        + " values (?, ?, ?, ?, ?)";
		

	}
	}
