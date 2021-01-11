package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.IOException;

public class FileDAO {
	/**
	 *  파일 읽기/쓰기 작업을 직접적으로 행하는 클래스
	 */
	private File f = new File("C:/mywork");
	
	public FileDAO() {
		if(!this.f.exists()) {
			f.mkdir();
		}
	}
	
	public String[] listFile() {
		/**
		 *  현재 위치에 존재하는 모든 파일 및 디렉터리 목록을 출력
		 */
		String[] list = f.list(); 
		return list;
	}
	
	public void addFile(String name) {
		File nf = new File("C:/mywork" + "/" + name);
		try {
			nf.createNewFile();
		} catch(IOException e) {
			System.out.println("파일 생성 중 IOException 발생");
		}
	}
}
