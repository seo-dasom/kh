package com.kh.exam;

public class Sample2 {
	
	public static void func1() {
		/*
		 * 2 ���� �迭 ����
		 */
		int[][] arr;			// 2 ���� �迭 ����
		arr = new int[2][3];	// 2 ���� �迭 ����(�⺻�� 0���� �ʱ�ȭ �Ǿ� ����)
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.printf("arr[%d][%d] -> %d\n", i, j, arr[i][j]);
			}
		}
//		for(int i = 0; i < 2; i++) {
//			System.out.printf("arr[%d][0] -> %d\n", i, arr[i][0]);
//			System.out.printf("arr[%d][1] -> %d\n", i, arr[i][1]);
//			System.out.printf("arr[%d][2] -> %d\n", i, arr[i][2]);
//		}
		
	}
	
	public static void func2() {
		/*
		 * 
		 */
		// int[][] arr = new int[][] {{24752, 365, 147},{26708, 357, 134}};
		int[][] arr = new int[2][3];
		arr[0][0] = 24752; arr[0][1] = 365; arr[0][2] = 147;
		arr[1][0] = 26708; arr[1][1] = 357; arr[1][2] = 134;
		/*
		 * ����	Ȯ����	�����	ġ���
		 * ����	24752	365		147
		 * ����	26708	357		134
		 */
		System.out.println("����\tȮ����\t�����\tġ���");
		for(int i = 0; i <= 1; i++) {
			if(i == 0) {
				System.out.print("����\t");
			} else {
				System.out.print("����\t");
			}
			for(int j = 0; j <= 2; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void func3() {
		int[][] arr = new int[9][3];
		arr[0][0] = 2479;	arr[0][1] = 384;	arr[0][2] = 1549;
		arr[1][0] = 4065;	arr[1][1] = 211;	arr[1][2] = 519;
		arr[2][0] = 8015;	arr[2][1] = 88;		arr[2][2] = 110;
		arr[3][0] = 9582;	arr[3][1] = 29;		arr[3][2] = 30;
		arr[4][0] = 7223;	arr[4][1] = 6;		arr[4][2] = 8;
		arr[5][0] = 6518;	arr[5][1] = 4;		arr[5][2] = 6;
		arr[6][0] = 8657;	arr[6][1] = 0;		arr[6][2] = 0;
		arr[7][0] = 3206;	arr[7][1] = 0;		arr[7][2] = 0;
		arr[8][0] = 1715;	arr[8][1] = 0;		arr[8][2] = 0;
		
		String[] rowName = {
				"80 �̻�", "70-79", "60-69", "50-59", "40-49",
				"30-39", "20-29", "10-19", "0-9"
		};
		
		System.out.println("����\t\tȮ����\t\t�����\t\tġ���");
		for(int j = 0; j <= 8; j++) {
			System.out.print(rowName[j] + "\t\t");
//			if(j == 0) {
//				System.out.print("80�̻�\t\t");
//			} else if(j == 1) {
//				System.out.print("70-79�̻�\t\t");
//			} else if(j == 2) {
//				System.out.print("60-69�̻�\t\t");
//			} else if(j == 3) {
//				System.out.print("50-59�̻�\t\t");
//			} else if(j == 4) {
//				System.out.print("40-49�̻�\t\t");
//			} else if(j == 5) {
//				System.out.print("30-39�̻�\t\t");
//			} else if(j == 6) {
//				System.out.print("20-29�̻�\t\t");
//			} else if(j == 7) {
//				System.out.print("10-19�̻�\t\t");
//			} else if(j == 8) {
//				System.out.print("0-9\t\t");
//			}
			for(int i = 0; i <=2; i++) {
				System.out.print(arr[j][i] + "\t\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void func4() {
		int[][] arr = new int[5][7];
		arr[0][0] = 1;	arr[0][1] = 2;	arr[0][2] = 3;	arr[0][3] = 4;	arr[0][4] = 5;	arr[0][5] = 6;	arr[0][6] = 7;
		arr[1][0] = 8;	arr[1][1] = 9;	arr[1][2] = 10;	arr[1][3] = 11;	arr[1][4] = 12;	arr[1][5] = 13;	arr[1][6] = 14;
		arr[2][0] = 15;	arr[2][1] = 16;	arr[2][2] = 17;	arr[2][3] = 18;	arr[2][4] = 19;	arr[2][5] = 20;	arr[2][6] = 21;
		arr[3][0] = 22;	arr[3][1] = 23;	arr[3][2] = 24;	arr[3][3] = 25;	arr[3][4] = 26;	arr[3][5] = 27;	arr[3][6] = 28;
		arr[4][0] = 29;	arr[4][1] = 30;	arr[4][2] = 0;	arr[4][3] = 0;	arr[4][4] = 0;	arr[4][5] = 0;	arr[4][6] = 0;
		
		int day = 1;
		for(int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 6; j++) {
				if(day <= 30) {
					arr[i][j] = day;
					day++;
				}
			}
		}
		/*			��	��	ȭ	��	��	��	��
		 * 	1����		1	2	3	4	5	6	7	
		 *	2����		8	9	10	11	12	13	14	
		 *	3����		15	16	17	18	19	20	21	
		 *	4����		22	23	24	25	26	27	28	
		 *	5����		29	30 
		 */
		
		System.out.println("\t��\t��\tȭ\t��\t��\t��\t��");
		for(int i = 0; i <= 4; i++) {
			System.out.printf("%d����\t" , i + 1);
			for(int j = 0; j <= 6; j++) {
				if(arr[i][j] != 0) {
					System.out.print(arr[i][j] + "\t");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void func5() {
		/*
		 *		�հ�		�����߻�	�ؿ�����	Ȯ��ȯ��	�ݸ���	�ݸ�����	�����	�߻���
		 *�հ�	1092	1060	32		52550	15085	36726	739		10135
		 *����	376		373		3		15732	6723	8864	145		16163
		 *�λ�	32		32		0		1571	461		1082	28		4605
		 *�뱸	24		24		0		7581	259		7122	200		31114
		 *��õ	49		46		3		2430	745		1665	20		8220
		 */
		int[][] arr = new int[5][8];
		arr[0][0] = 1092;	arr[0][1] = 1060;	arr[0][2] = 32;		arr[0][3] = 52550;	arr[0][4] = 15085;	arr[0][5] = 36726;	arr[0][6] = 739;	arr[0][7] = 10135;
		arr[1][0] = 376;	arr[1][1] = 373;	arr[1][2] = 3;		arr[1][3] = 15732;	arr[1][4] = 6723;	arr[1][5] = 8864;	arr[1][6] = 145;	arr[1][7] = 16163;
		arr[2][0] = 32;		arr[2][1] = 32;		arr[2][2] = 0;		arr[2][3] = 1571;	arr[2][4] = 461;	arr[2][5] = 1082;	arr[2][6] = 28;		arr[2][7] = 4605;
		arr[3][0] = 24;		arr[3][1] = 24;		arr[3][2] = 0;		arr[3][3] = 7581;	arr[3][4] = 259;	arr[3][5] = 7122;	arr[3][6] = 200;	arr[3][7] = 31114;
		arr[4][0] = 49;		arr[4][1] = 46;		arr[4][2] = 3;		arr[4][3] = 2430;	arr[4][4] = 745;	arr[4][5] = 1665;	arr[4][6] = 20;		arr[4][7] = 8220;
		
		String[] rowName = new String[] {
				"�հ�", "����", "�λ�", "�뱸", "��õ"
		};
		
		System.out.println("�õ���\t�հ�\t�����߻�\t�ؿ�����\tȮ��ȯ��\t�ݸ���\t�ݸ�����\t�����\t�߻���");
		
		for(int i = 0; i <= 4; i++) {
			System.out.print(rowName[i] + "\t");
			for(int j = 0; j <= 7; j++) {
				if(j == 7) {
					System.out.print(arr[i][j] / 100.0 + "\t");
				} else {
					System.out.print(arr[i][j] + "\t");
				}
			}
			System.out.print("\n");
		}
/*		System.out.print("\t\t�հ�\t�����߻�\t�ؿ�����\tȮ��ȯ��\t�ݸ���\t�ݸ�����\t�����\t�߻���");
		for(int i = 0; i <= 4; i++) {
			if(i == 0) {
				System.out.print("\n�հ�\t\t");
			} else if(i == 1) {
				System.out.print("����\t\t");
			} else if(i == 2) {
				System.out.print("�λ�\t\t");
			} else if(i == 3) {
				System.out.print("�뱸\t\t");
			} else if(i == 4) {
				System.out.print("��õ\t\t");
			}
			for(int j = 0; j <= 7; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.print("\n");
		}
*/	}
	
	public static void main(String[] args) {
		func5();
		//func4();
		//func3();
		//func2();
		//func1();
	}

}
