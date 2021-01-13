package com.kh.CRP.model.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CRPDAO {
	
	private String path;
	
	public CRPDAO() {
		this.path = "C:/score.txt";
	}
	
	public CRPDAO(String path) {
		this.path = path;
	}
	
	public void save(int[] score) {
		File f = new File(path);
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(String.format("%d,%d,%d", score[0], score[1], score[2]));
			fw.close();
		} catch (IOException e) {
			System.out.println("파일 입출력에 문제가 발생 했습니다.");
		}
	}
	
	public int[] load() {
		File f = new File(path);
		String[] score = new String[] { "0", "0", "0" };
		int[] res = new int[3];
		try {
			FileReader fr = new FileReader(f);
			String strRead = "";
			int len;
			char[] buff = new char[32];
			while((len = fr.read(buff)) != -1) {
				strRead += new String(buff, 0, len);
			}
			score = strRead.split(",");
			fr.close();
		} catch (IOException e) {
			System.out.println("파일 입출력에 문제가 발생 했습니다.");
		}
		for(int i = 0; i < score.length; i++) {
			res[i] = Integer.parseInt(score[i]);
		}
		return res;
	}
}
