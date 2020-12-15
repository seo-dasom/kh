package com.kh.exam01;

public class Sample1 {

	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = !b1;
		System.out.print(b1);
		System.out.print(" " + b2 + "\n");
		
		//++ -> +1 증가, -- -> -1 감소
		int n1 = 10;
		System.out.println(++n1); // 증가 계산 후 출력(전위)
		
		int n2 = 20;
		System.out.println(n2++); // 출력 후 증가 계산(후위)
		System.out.println(n2);
		
		int n3 = 15;
		System.out.println(--n3); // 감소 계산 후 출력(전위)
		
		int n4 = 25;
		System.out.println(n4--); //출력 후 감소 계산(후위)
		System.out.println(n4);
		
		// 산술 연산 : +, -, *, /, %(나머지)
		System.out.println("몫 : " + 10 / 3);
		System.out.println("나머지 : "+ 10 % 3);
		System.out.println("나머지가 0 이면 3의 배수 12 % 3 -> " + 12 % 3);
		System.out.println("나머지가 1 이면 홀수 11 % 2 -> " + 11 % 2);
		
		// 비교연산 : ==(같다), !=(다르다), >(왼쪽값이 크다), <(왼쪽값이 작다)
		//         >=(왼쪽값이 크거나 같다), <=(왼쪽값이 작거나 같다)
		// 비교연산의 결과는 논리값(true, false)으로 나온다.
		System.out.println(1 == 1);
		System.out.println(1 == 2);
		System.out.println(1 != 2);
		System.out.println(1 > 2);
		System.out.println(1 < 2);
		System.out.println(1 >= 2);
		System.out.println(1 <= 2);
		
		// 논리연산 : 논리값을 사용한 연산
		//          &&(and 연산) : 두 피연산자의 논리값이 true 일때 true가 된다.
		//          ||(or 연산) : 두 피연산자 중의 하나의 논리값이 true 일때 true가 된다.
		System.out.println("true && true -> " + (true && true));
		System.out.println("true && false -> " + (true && false));
		System.out.println("false && true -> " + (false && true));
		System.out.println("false && false -> " + (false && false));
		
		System.out.println("true || true -> " + (true || true));
		System.out.println("true || false -> " + (true || false));
		System.out.println("false || true -> " + (false || true));
		System.out.println("false || false -> " + (false || false));
		
		// 비트연산 : 2진수 값에 대한 연산을 수행
		//         &(bit and 연산) : 두 비트의 값이 1일때 1이 된다.
		//         |(bit or 연산) : 두 비트의 값 중 하나의 비트가 1일때 1이 된다.
		//         ^(bit xor 연산) : 두 비트의 값이 같으면 0, 다르면 1이 된다.
		//                         베타적 논리합
		//         >>(쉬프트 연산) : 오른쪽 방향으로 비트 이동(1비트 이동시 2로 나눈 효과)
		//         <<(쉬프트 연산) : 왼쪽 방향으로 비트 이동(1비트 이동시 2로 곱한 효과)
		//         >>>(쉬프트 연산) : 오른쪽 방향으로 비트 이동(부호비트에 대한 고려 없이 0을 채움)
		// 10 & 6 -> 1010 & 0110 -> 0010 -> 2
		// 10 | 6 -> 1010 | 0110 -> 1110 -> 14
		// 10 | 6 -> 1010 ^ 0110 -> 1100 -> 12
		System.out.println(10 & 6);
		System.out.println(10 | 6);
		System.out.println(10 ^ 6);
		System.out.println(-10 | -6);
		System.out.println(-10 & -6);
		// 1010 -> 101(5) -> 10(2)
		System.out.println(10 >> 1);
		System.out.println(5 >> 1);
		// 1010 -> 10100(20) -> 101000(40)
		System.out.println(10 << 1);
		System.out.println(20 << 1);
		System.out.println(-10 >> 1);
		System.out.println(-10 >>> 1);
		
		// 복합 대입 연산자 : 산술, 비트 연산을 수행 후 대입까지 수행하는 연산자
		int x = 0;
		x = x + 10;
		System.out.println(x);
		
		int y = 0;
		y += 10;   // 1씩 증가하는 값은 ++y 사용하면 되지만, 2 이상씩 증가 감소
		// 하는 연산에 대한 코드 작성할 때 많이 사용
		System.out.println(y);
		
		// 삼항 연산자
		// 조건식 ? 식1 : 식2;
		//조건식이 참이면 식1 수행, 조건식이 거짓이면 식2 수행
		int z = 8;
		boolean b3;
		
		//   조건식       ?  식1  :  식2;
		b3 = z % 2 == 0 ? true : false;
		System.out.printf("정수 %d는 짝수가 %b\n", z, b3);
		
		// 삼항 연산 중첩
		String s;
		s = z < 10 ? z % 2 == 1 ? "z는 10보다 작고 홀수" : "z는 10보다 작고 짝수" : "z는 10초과";
		System.out.println(s);
	}

}
