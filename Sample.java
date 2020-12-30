package com.kh.exam1;

import java.util.Scanner;

class UserInfo {
	private String name;
	private int age;
	private char gender;
	
	public UserInfo(String name, int age) {
		this.name = name;
		this.age = age;
	};
	
	public UserInfo(String name, int age, char gender) {
		this(name, age);
		this.gender = gender;
	}
	
	public String information() {
		// information 메서드로 이름, 나이 확인 가능하기 때문에
		// getName(), getAge() 메서드는 안 만들었다.
		return this.name + "님의 나이는 " + this.age + "세 입니다.";
	}

	public char getGender() {
		return gender;
	}
	
//	public char[] getGender() {
//		char[] c = { 'a', 'b', 'c' };
//		return c;
//	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

class UserController {
	private UserInfo[] info;
	private int count = 1;
	
	public UserController(int count) {
		this.count = count;
		info = new UserInfo[this.count];
	}
	
	public void add(String name, int age, int index) {
		this.info[index] = new UserInfo(name, age);
	}
	
	public UserInfo[] information() {
		return info;
	}
}

public class Sample {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UserController uc = new UserController(3);
		uc.add("홍길동", 30, 0);
		uc.add("김철수", 35, 1);
		uc.add("박보람", 33, 2);
		
		UserInfo[] u = uc.information();
		for(int i = 0; i < u.length; i++) {
			System.out.println(u[i].information());
		}
/*		String name;
		int age;
		
		UserInfo[] info = new UserInfo[3];
		
		for(int i = 0; i < info.length; i++) {
			System.out.print("이름 : "); 		name = sc.next();
			System.out.print("나이 : "); 		age = sc.nextInt();
			info[i] = new UserInfo(name,age);
		}
		info[0] = new UserInfo("홍길동", 30);
		info[1] = new UserInfo("김철수", 35);
		info[2] = new UserInfo("박보람", 33);
		
		for(int i = 0; i < info.length; i++) {
			System.out.println(info[i].information());
		}
*/	}

}
