package package3.controller;

import package3.model.vo.*;

public class AnimalManager {
	
	public static void main(String[] args) {
		Animal[] animal = new Animal[5];
		
		animal[0] = new Cat("도도", "코리안 숏헤어", "침대", "검은색");
		animal[1] = new Dog("요미", "요크셔테리어", 4);
		animal[2] = new Cat("초롱이", "치즈 테비", "담요", "하얀색");
		animal[3] = new Dog("뽀뽀", "슈나우저", 5);
		animal[4] = new Dog("사랑이", "말티즈", 3);
		
		for(int i = 0; i < animal.length; i++) {
			animal[i].speak();
		}
	}

}
