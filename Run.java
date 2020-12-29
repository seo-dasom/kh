package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.inform();
		
		System.out.println("===========================");
		
		Book b2 = new Book("자바", "KH정보보안", "KH교육원");
		b2.inform();
		
		System.out.println("===========================");
		
		Book b3 = new Book("자바", "KH정보보안", "KH교육원", 10000, 0.1);
		b3.inform();
	}

}
