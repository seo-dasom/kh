package com.kh.exam2;

/*
 * 동물 슈퍼 클래스 생성
 * 
 * 개, 고양이, 호랑이, 소, 쥐, 말 등등 서브 클래스 생성
 * 
 * 멤버 필드
 * 	나이, 신장, 몸무게
 * 
 * 멤버 메서드
 * 	달리기, 걷기, 먹기, 울음소리
 */

class Animal {
	private int age;
	private double tall;
	private double weight;
	
	public Animal(int age, double tall, double weight) {
		this.age = age;
		this.tall = tall;
		this.weight = weight;
	}
	
	public void run() {
		System.out.println("동물이 달립니다");
	}
	public void walk() {
		System.out.println("동물이 걷습니다.");
	}
	public void eat() {
		System.out.println("동물이 음식을 먹습니다.");
	}
	public void howling() {
		System.out.println("동물이 울음소리를 내고 있습니다.");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}

class Dog extends Animal {
	private String name = "개";
	
	public Dog(int age, double tall, double weight) {
		super(age, tall, weight);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println(this.name + "가 신나게 달립니다.");
	}
	
	@Override
	public void walk() {
		super.walk();
		System.out.println(this.name + "가 주인과 같이 걷고 있습니다.");
	}
	
	public void sitDown() {
		System.out.println(this.name + "가 앉았습니다.");
	}
	
	@Override
	public String toString() {
		// Object 클래스의 메서드를 재정의 해서
		// 출력을 할 때 원하는 문자열로 출력할 수 있게 만들 수 있다.
		return this.name + " 나이 : " + this.getAge() + " | 신장 : " + this.getTall();
	}
}

class Cat extends Animal {
	private String name = "고양이";
	
	public Cat(int age, double tall, double weight) {
		super(age, tall, weight);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println(this.name + "가 재빠르게 달려가고 있습니다.");
	}
	
	@Override
	public void walk() {
		super.walk();
		System.out.println(this.name + "가 사뿐사뿐 걷고 있습니다.");
	}
	
	public void box() {
		System.out.println(this.name + "가 박스에 들어 갔습니다.");
	}
	
	@Override
	public String toString() {
		// Object 클래스의 메서드를 재정의 해서
		// 출력을 할 때 원하는 문자열로 출력할 수 있게 만들 수 있다.
		return this.name + " 나이 : " + this.getAge() + " | 신장 : " + this.getTall();
	}
}

public class Sample1 {

	public static void main(String[] args) {
		/* Dog[] dogArray = new Dog[3];
		dogArray[0] = new Dog(1, 120.0, 3.0);
		dogArray[1] = new Dog(1, 120.0, 3.0);
		dogArray[2] = new Dog(1, 120.0, 3.0);
		*/
		Animal[] aniArray = new Animal[3];
		aniArray[0] = new Dog(1, 120.0, 3.0);
		aniArray[1] = new Cat(1, 120.0, 3.0);
		aniArray[2] = new Dog(1, 120.0, 3.0);
		
		Dog dog = new Dog(1, 100.0, 2.5);
		Cat cat = new Cat(2, 65.5, 1.5);
		
		dog.run();		dog.sitDown();
		cat.run();		cat.box();
		
		System.out.println(dog);
		System.out.println(cat);
	}

}
