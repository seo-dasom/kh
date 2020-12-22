package com.kh.practice.array;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ArrayPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		/*
		 * ���̰� 10�� �迭�� �����ϰ� 1���� 10������ ����
		 * �ݺ��� �̿��Ͽ� ������ȣ �迭 �ε����� ���� �� ���
		 */
		int[] arr = new int[10];
		int num = 1;
		
		// 1 ~ 10 ������ ���� �����ϱ� ���� ������ ������ ���
		for(int i = 0; i < arr.length; i++) {
			arr[i] = num;
			num += 1;
		}
		
		// 1 ~ 10 ������ ���� �����ϱ� ���� i ���� Ȱ��
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice2() {
		/*
		 * ���̰� 10�� �迭�� �����ϰ� 1 ~ 10������ ���� �ݺ�����
		 * �̿��Ͽ� �������� �迭 �ε����� ���� �� �� ���� ���
		 * 10 9 8 7 6 5 4 3 2 1
		 */
		int[] arr = new int[10];
		int num = 10;
		
		// 10 ~ 1 ������ ���� ������ ������ ���� ���
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = num;
//			num--;
//		}
		
		// �迭�� ������ 10 ~ 1 ������ ���� ������ ������ �����Ͽ� ���
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}
		
		// �迭�� ������ 10 ~ 1 ������ ���� i ������ Ȱ��
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice3() {
		/*
		 * ����ڿ��� �Է¹��� ���� ������ŭ �迭 ũ�⸦ �Ҵ�
		 * 1 ���� �Է� ���� ������ �迭�� �ʱ�ȭ �� ���
		 */
		int arrSize;
		
		while(true) {
			System.out.print("���� ���� : ");
			arrSize = sc.nextInt();
			if(arrSize > 0) {
				break;
			}
		}
		
		int[] arrVar = new int[arrSize];
		
		// �迭�� 1 ~ ����� �Է� ������ �ʱ�ȭ
		for(int i = 0; i < arrVar.length; i++) {
			arrVar[i] = i + 1;
		}
		
		//���
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
		}
	}
	
	public static void practice4() {
		/*
		 * ���̰� 5�� String �迭�� ����
		 * "���", "��", "����", "������", "����" ��
		 * �ʱ�ȭ �� �迭 �ε����� Ȱ���Ͽ� ���� ���
		 */
		String[] arrVar = {"���", "����", "��", "������", "����"};
		
		for(int i = 0; i < arrVar.length; i++) {
			if("��".equals(arrVar[i])) {
				System.out.println("��ġ �� -> " + i + "\t���ڿ� -> " + arrVar[i]);
			}
		}
	}
	
	public static void practice5() {
		/*
		 * ���ڿ��� �Է� �޾� �ϳ��ϳ� �迭�� �ְ�
		 * ���ڰ� ���ڿ��� �� �� �� �ִ��� ������ �� ��° �ִ��� ���
		 */
		String word;
		char ch;
		char[] chArr;
		int count = 0;
		
		System.out.print("���ڿ� : ");
		word = sc.next();
		
		System.out.print("���� : ");
		ch = sc.next().charAt(0);
		
		// ���ڿ��� ���� ��ŭ ���ڹ迭 ����
		chArr = new char[word.length()];
		
		// ���ڿ��� �ε����� ���ڹ迭�� �ε����� Ȱ���Ͽ�
		// ���ڿ��� ���ڸ� ���ڹ迭�� ����
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = word.charAt(i);
		}
		
		System.out.print(word + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");
		for(int i = 0; i < chArr.length; i++) {
			if(ch == chArr[i]) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n" + ch + " ���� : " + count);
		
//		for(int i = 0; i < chArr.length; i++) {
//			System.out.print(chArr[i]);
//		}
	}
	
	public static void practice6() {
		/*
		 *  "��" ~ "��" ���� �ʱ�ȭ�� ���ڿ� �迭 �����
		 *  0���� 6���� ���ڸ� �Է� �޾�,
		 *  �Է��� ���ڿ� ���� �ε����� �ִ� ������ ���
		 *  ������ ���� ���� �Է� �� "�߸� �Է��ϼ̽��ϴ�" ���
		 *  (Ȱ�� -> 1 ~ 31 ������ ���ڰ��� �Է¹޾� �׿� �����ϴ� ���� ���)
		 */
		String[] week = {"��", "ȭ", "��", "��", "��", "��", "��"};
		int day;
		
		while(true) {
			System.out.print("1 ~ 31 ���� ���� �Է� : ");
			day = sc.nextInt();
			if(day >= 1 && day <= 31) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		System.out.println(week[day % 7]);
	}
	
	public static void practice7() {
		/*
		 * ����ڰ� �迭�� ���̸� �Է�
		 * �� ����ŭ ������ �迭�� ���� �� �Ҵ�
		 * �迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է� -> ������ �ε����� ���� �ʱ�ȭ
		 * �迭 ��ü ���� �����ϰ� �ε����� ����� ������ ���� ���
		 */
		int[] arrVar;
		int num, total;
		
		System.out.print("���� : ");
		num = sc.nextInt();
		
		arrVar = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("�迭 " + i + "��° �ε����� ���� �� : ");
			arrVar[i] = sc.nextInt();
		}
		
		total = 0;
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
			total = total + arrVar[i];
		}
		
		System.out.println("\n�� �� : " + total);
	}
	
	public static void practice8() {
		/*
		 * 3 �̻��� Ȧ�� �ڿ����� �Է¹ޱ�
		 * �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ �� �ְ�,
		 * �߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ �� �־� ���.
		 * ��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ���
		 * "�ٽ� �Է��ϼ���"�� ����ϰ� �ٽ� ���� �ޱ�
		 * 
		 */
		int num1;	// ����� �Է��� �޾� �����ϱ� ���� ����
		int[] arr;	// ������ �迭 ����, ����ڰ� �Է��� ũ���� �迭�� ������ ��.
		
		while(true) {
			System.out.print("���� : ");
			num1 = sc.nextInt();
			if(num1 >= 3 && num1 % 2 == 1) {
				// 3 �̻��� Ȧ����.
				break;
			}
			System.out.println("3 �̻��� Ȧ�� ������ �ٽ� �Է��ϼ���.");
		}
		
		arr = new int[num1];
		/* ���� : 5				�߰� ��ġ : 5 / 2 -> 2
		 * 1, 2, 3, 2, 1
		 * 
		 * ���� : 7				�߰� ��ġ : 7 / 2 -> 3
		 * 1, 2, 3, 4, 3, 2, 1
		 * 						�߰� ��ġ : n / 2 -> �迭�� �߰��� �ش��ϴ� �ε���
		 */
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = value;
			if(i < arr.length / 2) {
				// �迭�� ������ �� ����.
				value++;
			} else {
				// �迭�� ������ �� ����.
				value--;
			}
		}
		// ��� ���
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
		
//		int num, temp = 1;
//		int[] arrVar; // �迭 ������
		

//		while(true) {
//			System.out.print("���� : ");
//			num = sc.nextInt();
		
//			if(num >= 3 && num % 2 == 1) {
//				break;
//			}
//			System.out.println("3�̻� Ȧ�� ������ �ٽ� �Է��ϼ���.");
//		}
//		arrVar = new int[num];
			
//		// �迭�� ũ�� 5 -> 1, 2, 3, 2, 1
//		for(int i = 0; i < arrVar.length; i++) {
//			arrVar[i] = temp;
//			if(i < arrVar.length / 2) {
//				temp++;
//			} else {
//				temp--;
//			}
//		}
//		for(int i = 0; i < arrVar.length - 1; i++) {
//			System.out.printf("%d, ", arrVar[i]);
//		}
//		System.out.printf("%d\n", arrVar[arrVar.length-1]);
	}
	
	public static void practice8_1() {
		/*
		 * 3 �̻��� Ȧ�� �ڿ����� �Է¹ޱ�
		 * �迭�� �߰������� 1���� 1�� ���ҽ�Ű��,
		 * �߰� ���ĺ��� �������� 1�� ������ ���� �迭�� �־� ���.
		 * 
		 * ���� : 5				���� �� : 5 / 2 + 1
		 * 3, 2, 1, 2, 3
		 * 
		 * ���� : 7				���� �� : 7 / 2 + 1
		 * 4, 3, 2, 1, 2, 3, 4
		 * 
		 * ���� : 15				���� �� : 15 / 2 + 1
		 * 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8
		 */
		int num;
		int[] arr;
		
		while(true) {
			System.out.print("���� : ");
			num = sc.nextInt();
			
			if(num >= 3  && num % 2 == 1) {
				break;
			}
			System.out.println("3 �̻��� Ȧ�� ������ �ٽ� �Է��ϼ���.");
		}
		
		arr = new int[num];
		
		int value = arr.length / 2 + 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = value;
			if(i < arr.length / 2) {
				value--;
			} else {
				value++;
			}
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
	}
	
	public static void practice9() {
		/*
		 * ����� �Է�
		 * �Է��� ���� �迭�� �ִ��� �˻�
		 * ������ "ooġŲ ��� ����", ������ "ooġŲ�� ���� �޴��Դϴ�" ���
		 * �޴� �迭�� ���� ���ϱ�.
		 */
		String[] menu = {"�Ķ��̵�", "���", "����õ��", "�����޺�", "������"};
		String name;
		boolean find = false;
		int index = 0;
		
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		name = sc.next();
		
		for(int i = 0; i < menu.length; i++) {
			if(name.equals(menu[i])) {
				find = true;
				index = i;
			}
		}
		if(find) {
			System.out.println(menu[index] + "ġŲ ��� ����");
		} else {
			System.out.println(name + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	public static void practice9_1() {
		
		String[] chickens = {"�Ķ��̵�", "���", "����", "����", "ũ������", "��"};
		String search;
		boolean find = false; // �޴��� ã�� ��� true�� ����
		int index = 0;
		
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		search = sc.next();
		
		for(int i = 0; i < chickens.length; i++) {
			if(chickens[i].equals(search)) {
				find = true;
				index = i;
				break;
			}
		}
		
		if(find) {
			System.out.println(chickens[index] + "ġŲ ��� ����");
		} else {
			System.out.println(search + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
		public static void practice9_2() {
		/*
		 * ġŲ �޴��� �迭�� ������ ũ���� ġŲ �޴��� ������ �����ϴ� �迭�� �����ϰ�
		 * ����ڰ� �Է��� ���ڿ��� ġŲ �޴� �迭�� �����ϴ��� �˻� ��
		 * �����ϸ� " xxx ġŲ ������ XXXXX�� �Դϴ�." ������
		 * "xxx ġŲ�� ���� �޴��Դϴ�." ���
		 */
		String[] chickens = {"�Ķ��̵�", "���", "����", "����", "ũ������", "��"};
		int[] chickensAmount = {10000, 11000, 12000, 12000, 9000, 11000};
		String search;
		boolean find = false; // �޴��� ã�� ��� true�� ����
		int index = 0;
		
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		search = sc.next();
		
		for(int i = 0; i < chickens.length; i++) {
			if(chickens[i].equals(search)) {
				find = true;
				index = i;
				break;
			}
		}
		
		if(find) {
			System.out.println(chickens[index] + "ġŲ ������ " + chickensAmount[index] + "�� �Դϴ�.");
		} else {
			System.out.println(search + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	public static void practice10() {
		/*
		 * �ֹε�Ϲ�ȣ(-����) �Է�
		 * �����ڸ� ���ĺ��� *�� ������ ���
		 * ��, ������ �����ϸ鼭 ���纻���� *�� ������ ���� �� ���
		 */
		String id = "";
		char[] idArr, copArr;
		
		while(true) {
			System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
			id = sc.next();
			
			if(id.length() == 14 && id.charAt(6) == '-') {
				break;
			}
		}
		// �迭 ������ ���ϱ�
		idArr = new char[id.length()];
		copArr = new char[id.length()];
		
		// �Էµ� �ֹι�ȣ �迭�� �����
		for(int i = 0; i < id.length(); i++) {
			idArr[i] = id.charAt(i);
		}
		
		// �������� ī�Ǻ����� -> �ٸ� �迭�� ����
		// 123456-1234567
		System.arraycopy(idArr, 0, copArr, 0, 8);
		for(int i = 8; i < idArr.length; i++) {
			copArr[i] = '*';
		}
		// ����� �迭 ���
		for(int i = 0; i < copArr.length; i++) {
			System.out.print(copArr[i]);
		}
	}
	
	public static void practice10_1() {
		/*
		 * �ֹε�Ϲ�ȣ(-����) �Է�
		 * �����ڸ� ���ĺ��� *�� ������ ���
		 * ��, ������ �����ϸ鼭 ���纻���� *�� ������ ���� �� ���
		 * 
		 * ����� ���ÿ� ���� ���� ������ �ֹε�Ϲ�ȣ�� *�� ���纻�� �����ϴ� �Ͱ�
		 * ��������� ����� ������ �ֹε�� ��ȣ�� *�� ���纻�� �����ϴ� ������ ����
		 * 
		 * 123456-1234567 -> ���� ������ ��ȣ	-> 123456-1******
		 * 123456-1234567 -> ����� ������ ��ȣ	-> 1234**-*******
		 */
		String jumin;
		String temp;
		
		// �ݵ�� - ������ �Ǿ� �ִ��� üũ.
		// �ֹε�Ϲ�ȣ ���̰� - �����Ͽ� 14 �� ���� üũ.
		// 123456-1234567
		while(true) {
			System.out.print("�ֹε�Ϲ�ȣ(- ����) : ");
			jumin = sc.next();
			if(jumin.length() != 14) {
				System.out.println("�ֹε�Ϲ�ȣ�� - �����Ͽ� 14�� �Դϴ�.");
				continue;
			}
			if(jumin.charAt(6) != '-') {
				System.out.println("�ùٸ��� ���� �ֹε�Ϲ�ȣ ���� �Դϴ�.");
				continue;
			}
			break;
		}
		while(true) {
			System.out.print("�ֹι�ȣ ����ó��(����, ����� ����) : ");
			temp = sc.next();
			
			if(temp.equals("����") || temp.equals("�����")) {
				break;
			}
			System.out.println("���� �Ǵ� ������� �Է��ϼ���.");
		}
		
		char[] orgJumin = new char[14];
		char[] copJumin = new char[14];
		char[] tmpJumin;
		
		// ���ڿ��� ���ڹ迭�� ����(��������)
		for(int i = 0; i < jumin.length(); i++) {
			orgJumin[i] = jumin.charAt(i);
		}
		
		// ���� ���ڹ迭�� �����͸� ���纻 ���ڹ迭�� ����
		// �������� ������ ���� *�� ����
		// 123456-1234567
		if(temp.equals("����")) {
			for(int i = 0; i < orgJumin.length; i++) {
				if(i <= 7) {
					copJumin[i] = orgJumin[i];
				} else {
					copJumin[i] = '*';
				}
			}
			
		} else {
			for(int i = 0; i < orgJumin.length; i++) {
				if(i <= 3) {
					copJumin[i] = orgJumin[i];
				} else {
					copJumin[i] = '*';
					if(i == 6) {
						copJumin[i] = '-';
					}
				}
			}
		}
		System.out.print("���� �ֹι�ȣ : ");
		for(int i = 0; i < orgJumin.length; i++) {
			System.out.print(orgJumin[i]);
		}
		System.out.print("\n");
		
		System.out.print("���纻 �ֹι�ȣ : ");
		for(int i = 0; i < copJumin.length; i++) {
			System.out.print(copJumin[i]);
		}
	}
	
	public static void practice12() {
		/*
		 *  10���� ���� ������ �� �ִ� �迭 ���� �� 1 ~ 10 ������ ������ �����Ͽ�
		 *  �ʱ�ȭ �� �迭 ��ü�� �� ��� �� �ִ밪, �ּҰ��� ���
		 */
		Random rand = new Random();
		int[] randArr = new int[10];
		
		for(int i = 0; i < randArr.length; i++) {
			randArr[i] = rand.nextInt(10) + 1;
		}
		
		for(int i = 0; i < randArr.length; i++) {
			System.out.print(randArr[i] + " ");
		}
		
		// �ִ밪, �ּҰ�
		int max = randArr[0], min = randArr[0];
		for(int i = 1; i < randArr.length; i++) {
			if(randArr[i] > max) {
				max = randArr[i];
			}
			if(randArr[i] < min) {
				min = randArr[i];
			}
		}
		System.out.println("\n�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
	}
	
	public static void practice13() {
		/*
		 *  10���� ���� ������ �� �ִ� �迭 ���� �� 1 ~ 10 ������ ������ �����Ͽ� �ʱ�ȭ
		 *  ��, �ߺ��� ���� ���� �ȵȴ�.
		 */
		Random rand = new Random();
		int[] randArr = new int[10];
		int temp;
		boolean dup = false;		// �ߺ��� �������� ������ �����ϱ� ���� ����
		
		randArr[0] = rand.nextInt(10) + 1;
		for(int i = 1; i < randArr.length;) {
			dup = false;
			temp = rand.nextInt(10) + 1;
			for(int j = 0; j < i; j++) {
				if(randArr[j] == temp) {
					dup = true;
					break;
				}
			}
			if(!dup) {	// �ߺ��� �ƴϸ�, �߰�
				randArr[i] = temp;
				i++;
			}
		}
		
		for(int i = 0; i < randArr.length; i++) {
			System.out.print(randArr[i] + " ");
		}
	}
	
	public static void practice14() {
		
	}
	
	public static void practice15() {
		
	}
	
	public static void practice16() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//practice16();
		//practice15();
		//practice14();
		practice13();
		//practice12();
		//practice10_1();
		//practice10();
		//practice9_2();
		//practice9_1();
		//practice9();
		//practice8_1();
		//practice8();
		//practice7();
		//practice6();
		//practice5();
		//practice4();
		//practice3();
		//practice2();
		//practice1();
	}

}
