package com.kh.exam1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Sample1 {
	
	private static File f;
	
	public static String[] getDirList(String path) {
		/*
		 *  지정한 디렉터리의 모든 파일 및 디렉터리 목록을 반환하는 메서드
		 *  반환형은 문자열 배열
		 *  단, 디렉터리만 반환한다. .isDirectory()
		 */
		f = new File(path);
		
		if(!f.exists()) {
			System.out.println(path + " 에 해당하는 디렉터리 또는 파일이 존재하지 않습니다.");
			return new String[] { "" };
		}
		
		File[] fList = f.listFiles();
		String[] sList = new String[fList.length];
		int idx = 0;
		for(int i = 0; i < fList.length; i++) {
			if(fList[i].isDirectory()) {
				sList[idx] = fList[i].getName();
				idx++;
			}
		}
		String[] res = new String[idx];
		System.arraycopy(sList, 0, res, 0, idx);
		return res;
	}
	
	public static String[] getFileList(String path) {
		/*
		 *  지정한 디렉터리의 모든 파일 및 디렉터리 목록을 반환하는 메서드
		 *  반환형은 문자열 배열
		 *  단, 파일만 반환한다. .isFile()
		 */
		f = new File(path);
		
		if(!f.exists()) {
			System.out.println(path + " 에 해당하는 디렉터리 또는 파일이 존재하지 않습니다.");
			return new String[] { "" };
		}
		File[] fList = f.listFiles();
		String[] sList = new String[fList.length];
		int idx = 0;
		for(int i = 0; i < fList.length; i++) {
			if(fList[i].isFile()) {
				sList[idx] = fList[i].getName();
				idx++;
			}
		}
		String[] res = new String[idx];
		System.arraycopy(sList, 0, res, 0, idx);
		return res;
	}
	
	public static String[] getList(String path) {
		/*
		 *  지정한 디렉터리의 모든 파일 및 디렉터리 목록을 반환하는 메서드
		 *  반환형은 문자열 배열
		 *  단, 숨김 파일에 대해서는 반환하지 않게 만든다.
		 */
		f = new File(path);
		
		if(!f.exists()) {
			System.out.println(path + " 에 해당하는 디렉터리 또는 파일이 존재하지 않습니다.");
			return new String[] { "" };
		}
		File[] fList = f.listFiles();
		String[] sList = new String[fList.length];
		int idx = 0;
		for(int i = 0; i < fList.length; i++) {
			if(!fList[i].isHidden()) {
				sList[idx] = fList[i].getName();
				idx++;
			}
		}
		String[] res = new String[idx];
		System.arraycopy(sList, 0, res, 0, idx);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getList("C:/")));
		System.out.println(Arrays.toString(getDirList("C:/")));
		System.out.println(Arrays.toString(getFileList("C:/")));
/*		File f = new File("C:/Sample.txt");
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
		
		new File("C:/newFolder/sam").delete();*/
	}

}
