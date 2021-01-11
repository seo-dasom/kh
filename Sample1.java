package com.kh.exam1;

import java.io.File;
import java.io.IOException;

public class Sample1 {

	public static void main(String[] args) {
		File f = new File("C:/Sample.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			System.out.println("IOException 에러 발생");
		}
		System.out.println(f.getName() + " 읽기 가능? : " + f.canRead());
		System.out.println(f.getName() + " 쓰기 가능? : " + f.canWrite());
		System.out.println(f.getName() + " 실행 가능? : " + f.canExecute());
		System.out.println(f.getName() + " 디렉터리? : " + f.isDirectory());
		System.out.println(f.getName() + " 파일? : " + f.isFile());
		System.out.println(f.getName() + " 숨김? : " + f.isHidden());
		System.out.println(f.getName() + " 크기(바이트)? : " + f.length());
		System.out.println(f.getName() + " 마지막 수정날짜 : " + f.lastModified());
		
		f = new File("C:/");
		String[] fileList = f.list();
		for(int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
		}
		System.out.println("=========listFiles()=========");
		File[] fList = f.listFiles();
		for(int i = 0; i < fList.length; i++) {
			System.out.println(fList[i] + "\t" + fList[i].isHidden() + "\t" + fList[i].length());
		}
		
		f = new File("C:/newFolder");
		f.mkdir();
		
		f = new File("C:/newFolder/sam");
		f.mkdir();
		
		new File("C:/newFolder/sam").delete();
	}

}
