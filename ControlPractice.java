package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		// ���ǹ�_1�� ����
		int num;
		
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.println("�޴� ��ȣ�� �Է��ϼ��� : ");
		
		num = sc.nextInt();
		
//		if (num == 1) {
//			System.out.println("�Է� �޴��Դϴ�.");
//		} else if(num == 2) {
//			System.out.println("���� �޴��Դϴ�.");
//		} else if (num == 3) {
//			System.out.println("��ȸ �޴��Դϴ�.");
//		} else if (num == 4) {
//			System.out.println("���� �޴��Դϴ�.");
//		} else if (num == 7) {
//			System.out.println("���α׷��� ����˴ϴ�.");
//		} else {
//			System.out.println("�߸��� �޴� ��ȣ �Դϴ�.");
//		}
		
		switch(num) {
		case 1:
			System.out.println("�Է� �޴��Դϴ�."); break;
		case 2:
			System.out.println("���� �޴��Դϴ�."); break;
		case 3:
			System.out.println("��ȸ �޴��Դϴ�."); break;
		case 4:
			System.out.println("���� �޴��Դϴ�."); break;
		case 7:
			System.out.println("���α׷��� ����˴ϴ�."); break;
		default:
			System.out.println("�߸��� �޴� ��ȣ �Դϴ�.");
		}
	}
	
	public static void practice2() {
		// 2�� ����
		int num;
		
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		num = sc.nextInt();
		
//		if(num > 0) {
//			if(num % 2 == 0) {
//				System.out.println("¦����.");
//			} else {
//				System.out.println("Ȧ����.");
//			} 
//		} else {
//			System.out.println("����� �Է����ּ���.");
//		}
		
		if(num > 0) {
			switch(num % 2) {
			case 0:
				System.out.println("¦����."); break;
			case 1:
				System.out.println("Ȧ����."); break;
			}
		} else {
			System.out.println("����� �Է����ּ���.");
		}
	}
	
	public static void practice3() {
		int x, y, z, tot;
		double avg;

		System.out.print("�������� : ");
		x = sc.nextInt();
		
		System.out.print("�������� : ");
		y = sc.nextInt();
		
		System.out.print("�������� : ");
		z = sc.nextInt();
		
		tot = x + y + z;
		avg = tot / 3.0;

		if (x >= 40 && y >= 40 && z >= 40 && avg >=60) {
			System.out.printf("���� : %d ��\n", x);
			System.out.printf("���� : %d ��\n", y);
			System.out.printf("���� : %d ��\n", z);
			System.out.printf("�հ� : %d ��\n", tot);
			System.out.printf("��� : %.2f ��\n", avg);
			System.out.println("�����մϴ�. �հ��Դϴ�!");
		} else {
			System.out.println("���հ��Դϴ�.");
		}
	}
	public static void practice4() {
		
		int month = 0;
		String season;
		
		System.out.print("1~12 ������ ���� �Է� : ");
		month = sc.nextInt();
		
		switch(month) {
		
		case 1: case 2: case 12:
			season = "�ܿ�"; break;
		case 3: case 4: case 5:
			season = "��"; break;
		case 6 : case 7: case 8:
			season = "����"; break;
		case 9: case 10: case 11:
			season = "����"; break;
		default:
			season = "�߸� �Էµ� ���Դϴ�.";
		}
		
		System.out.printf("%d���� %s�Դϴ�.", month, season);
	}
	public static void practice5() {
		// 5�� ����
		String id, pw;
		String id_input, pw_input;
		
		id = "myId";   pw = "myPassword12";
		
		System.out.print("���̵� �Է� : ");
		id_input = sc.next();
		
		System.out.print("�н����� �Է� : ");
		pw_input = sc.next();
		
		if(id.equals(id_input) && pw.equals(pw_input)) {
			System.out.println("�α��� ����");
		} else {
			if(!id.equals(id_input) && !pw.equals(pw_input)) {
				System.out.println("���̵�� �н����尡 Ʋ�Ƚ��ϴ�.");
			} else if(!id.equals(id_input)){
				System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
			} else if(!pw.equals(pw_input)){
				System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
			}
		}
	}
	public static void practice6() {
		// 6�� ����
		String perm;
		
		System.out.print("ȸ�� ���(������, ȸ��, ��ȸ��) : ");
		perm = sc.next();
		
//		if(perm.equals("������")) {
//			System.out.println("ȸ������, �Խñ� ����, �Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
//		} else if(perm.equals("ȸ��")) {
//			System.out.println("�Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
//		} else if(perm.equals("��ȸ��")) {
//			System.out.println("�Խñ� ��ȸ");
//		} else {
//			System.out.println("�߸��� ���� ����Դϴ�.");
//		}
		String res = "";
		
		switch(perm) {
		case "������":
			res += "ȸ������, �Խñ� ����, ";  //// res = res + "ȸ������, �Խñ� ����";
		case "ȸ��":
			res += "�Խñ� �ۼ�, ��� �ۼ�, "; // res = res + "�Խñ� �ۼ�, ��� �ۼ�";
		case "��ȸ��":
			res += "�Խñ� ��ȸ";           // res = res + "�Խñ� ��ȸ";
			break;
		default:
			res = "�߸��� ���� ����Դϴ�.";
		}
		System.out.println(res);
	}
	public static void practice7() {
		// 7�� ���� BMI = ������ / (Ű(m)*Ű(m))
		double tall, weight, bmi;
		String res;
		
		System.out.print("Ű(cm)�� �Է����ּ��� : ");
		tall = sc.nextDouble();
		tall /= 100;      // tall = tall / 100;
		
		System.out.print("������(kg)�� �Է����ּ��� : ");
		weight = sc.nextDouble();
		
		bmi = weight / (tall * tall);
		
//		if(bmi < 18.5) {
//			res = "��ü��";
//		} else if(bmi >= 18.5 && bmi < 23) {
//			res = "����ü��";
//		} else if(bmi >= 23 && bmi < 25) {
//			res = "��ü��";
//		} else if(bmi >= 25 && bmi < 30) {
//			res = "��";
//		} else if(bmi >= 30) {
//			res = "����";
//		} else {
//			res = "�߸��� �Է°��� �ֽ��ϴ�.";
//		}

		if(bmi < 18.5) {
			res = "��ü��";
		} else if(bmi< 23) {
			res = "����ü��";
		} else if(bmi< 25) {
			res = "��ü��";
		} else if(bmi< 30) {
			res = "��";
		} else {
			res = "����";
		}
		
		System.out.printf("BMI ���� : %.2f\n", bmi);
		System.out.println(res);
	}
	public static void practice8() {
		// 8�� ����
		int a, b;
		int iRes = 0;   double dRes = 0.0;
		char op, flag;  // ��� ����� ����� �ڷ����� ������ �����ϱ� ���� �÷���, 'i', 'd'
		
		System.out.print("�ǿ����� 1 : ");
		a = sc.nextInt();
		
		System.out.print("�ǿ����� 2 : ");
		b = sc.nextInt();
		
		System.out.print("������(+,-,*,/,%) : ");
		op = sc.next().charAt(0);
		
		if( a > 0 && b > 0) {
		switch(op) {
		case '+' :
			iRes = a + b;  flag = 'i';
//			System.out.printf("%d + %d = %d", a, b, a + b);
			break;
		case '-' :
			iRes = a - b;  flag = 'i';
//			System.out.printf("%d - %d = %d", a, b, a - b);
			break;
		case '*' :
			iRes = a * b;  flag = 'i';
//			System.out.printf("%d * %d = %d", a, b, a * b);
			break;
		case '/' :
			dRes = (double)a / b;  flag = 'd';
//			System.out.printf("%d / %d = %d", a, b,(double)a / b);
			break;
		case '%' :
			iRes = a % b;  flag = 'i';
//			System.out.printf("%d %% %d = %d", a, b, a % b);
			break;
		default:
			flag = 'e';
			System.out.printf("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
//			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		   }
		if (flag == 'i') {
			System.out.printf("%d %c %d = %d", a, op, b, iRes);
		} else if (flag == 'd') {
			System.out.printf("%d %c %d = %f", a, op, b, dRes);
		}
		}
	}
	public static void practice9() {
		// 9�� ����
		double mid, fin, hw, att_jum, att_rate, tot;
		int att;
		
		System.out.print("�߰���� ���� : ");
		mid = sc.nextDouble();
		System.out.print("�⸻��� ���� : ");
		fin = sc.nextDouble();
		System.out.print("���� ���� : ");
		hw = sc.nextDouble();
		System.out.print("�⼮ ȸ�� : ");
		att = sc.nextInt();
		
		fin = fin / 100 * 30;
		hw = hw / 100 * 30;
		mid = mid / 100 * 20;
		att_jum = att / 20.0 * 20;
		att_rate = att / 20.0 * 100;
		tot = mid + fin + hw + att;
		
		System.out.println("=================���=================");
		System.out.println("�߰����(20) : " + mid);
		System.out.println("�⸻���(30) : " + fin);
		System.out.println("��������(30) : " + hw);
		System.out.println("�⼮����(20) : " + att_jum);
		System.out.println("���� : " + tot);
		
		if(tot >= 70) {
			if(100 - att_rate >= 30) {
				System.out.println("Fail [�⼮ ���� " + att + "/20]");
			} else {
				System.out.println("PASS");
			}
		} else {
			System.out.println("Fail [���� �̴�]");
		}
	}
	public static void practice10() {
		// 10�� ����
		
		int menu;
		
		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		
		System.out.print("���� : ");
		menu = sc.nextInt();
		
		switch(menu) {
		case 1 :
		    practice1();
			break;
		case 2 :
			practice2();
			break;
		case 3 :
			practice3();
			break;
		case 4 :
			practice4();
			break;
		case 5 :
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("�ùٸ� �޴��� �Է��ϼ���");	
		}
	}
	public static void main(String[] args) {
		practice10();
		sc.close();
	}

}
