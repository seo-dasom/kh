package com.kh.class2;

public class UserInfo {
	private String name;
	private int age;
	private char gender;
	
	public UserInfo() {};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getGender() {
		return gender;
	}

	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
}
