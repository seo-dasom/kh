package com.kh.practice.student.controller;

import com.kh.practice.student.model.vo.Student;

public class StudentController {
	// 5개의 객체배열을 위의 샘플 데이터 값으로 초기화 해주는 기본 생성자
	private Student[] sArr = new Student[1];
	
	public static final int CUT_LINE1 = 60;	// 클래스(정적) 변수(상수)
	public final int CUT_LINE2 = 60;		// 인스턴스 변수(상수)
	
	public StudentController() {
		// 5개의 객체배열을 위의 샘플 데이터의 값으로 초기화 해주는 기본 생성자
		/*
		sArr = new Student[5];
		sArr[0] = new Student("김길동", "자바", 100);
		sArr[1] = new Student("박길동", "디비", 50);
		sArr[2] = new Student("이길동", "화면", 85);
		sArr[3] = new Student("정길동", "서버", 60);
		sArr[4] = new Student("홍길동", "자바", 20);
		*/	
	}
	
	public Student[] printStudent() {
		// 객체 배열에 있는 데이터 반환
		return sArr;
	}
	
	public int sumScore() {
		// 객체 배열의 점수를 합한 값 리턴
		int sum = 0;
		for(int i = 0; i < sArr.length; i++) {
			sum += sArr[i].getScore();
		}
		return sum;
	}
	
	public double[] avgScore() {
		// double배열을 만들어 sumSore의 리턴 값을 0번째 인덱스에
		// 저장하고 합의 평균을 1번째 인덱스에 저장 후 배열 리턴
		double[] avg = new double[2];
		avg[0] = this.sumScore();
		avg[1] = (double)avg[0] / sArr.length;
		return avg;
	}
	
	public void add(String name, String subject, int score) {
		Student[] tmp = new Student[sArr.length + 1];
		System.arraycopy(sArr, 0, tmp, 0, sArr.length);
		tmp[tmp.length - 1] = new Student(name, subject, score);
		sArr = tmp;		// 얕은 복사
	}
	
	public void modify(String name, String subject, int score) {
		
	}

	public void delete(String name) {
	
	}

	public void printAll() {
		for(int i = 1; i < sArr.length; i++) {
			System.out.println(sArr[i].inform());
		}
	}


}
