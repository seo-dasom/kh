package com.kh.practice.comp;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static Scanner sc = new Scanner(System.in);
	public static void rps() {
		/*
		 * ����� �̸� �Է�
		 * ��ǻ�Ϳ� ����������
		 * ��ǻ�� (����,����,��)�� �������� ����
		 * ����ڿ��Դ� ���� ���������� ���
		 * ����ڰ� "exit"�� �Է��ϱ� ������ ��� ����
		 * "exit" �Է� �� �ݺ� ���߰�
		 * ����� �ºο��� ��� �̱��,��� ����,��� ������ ���.
		 */
		Random rand = new Random();
		
		String user, com, input = "";
		int win = 0, lose = 0, draw = 0;
		int random = 0;
		
		System.out.print("����� �̸��� �Է����ּ��� : ");
		user = sc.next();
		
		while(true) {
			random = rand.nextInt(3);
			if(random == 0) {
				com = "����";
			} else if(random == 1) {
				com = "����";
			} else {
				com = "��";
			}
			System.out.print("���������� : ");
			input = sc.next();
			
			if(input.equals("exit")) {
				System.out.println((win+draw+lose)+"�� "+win+"�� "+draw+"�� "+lose+"��");
				break;
			}
			
			System.out.printf("��ǻ�� : %s\n", com);
			System.out.println(user + " : " + input);
			
			switch(input) {
				case "����" :
					if(com.equals("����")) {
						System.out.println("�����ϴ�.");
						draw++;
					} else if(com.equals("����")) {
						System.out.println("�����ϴ� �Ф�");
						lose++;
					} else {
						System.out.println("�̰���ϴ� !");
						win++;
					}
					break;
				case "����" :
					if(com.equals("����")) {
						System.out.println("�����ϴ�.");
						draw++;
					} else if(com.equals("����")) {
						System.out.println("�����ϴ� �Ф�");
						lose++;
					} else {
						System.out.println("�̰���ϴ� !");
						win++;
					}
					break;
				case "��" :
					if(com.equals("��")) {
						System.out.println("�����ϴ�.");
						draw++;
					} else if(com.equals("����")) {
						System.out.println("�����ϴ� �Ф�");
						lose++;
					} else {
						System.out.println("�̰���ϴ� !");
						win++;
					}
					break;
					
					default :
						System.out.println("�߸� �Է��ϼ̽��ϴ�.\n");
				}
			}
		}
	
	public static void main(String[] args) {
		rps();
		sc.close();
	}
}