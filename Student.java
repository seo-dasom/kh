package com.kh.example.practice4.model.vo;

public class Student {
	private int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	{
		this.grade = 2;
		this.classroom = 2;
		this.name = "김고양";
		this.height = 156.3;
		this.gender = '여';
	}
	
//	public Student() {}		매개변수 없으면 생략 가능
	
	public void information() {
		System.out.println("학년 : " + this.grade);
		System.out.println("반 : " + this.classroom);
		System.out.println("이름 : " + this.name);
		System.out.println("키 : " + this.height);
		System.out.println("성별 : " + this.gender);
	}
}
