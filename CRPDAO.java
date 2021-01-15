package com.kh.CRP.model.dao;

import java.io.*;
import java.util.Properties;

public class CRPDAO {
	private String path;
	private Properties prop;
	private String[] keys = new String[] { "w", "l", "d" };
	
	public CRPDAO() {
		this.path = "C:/Users/projava/score.txt";
		this.prop = new Properties();
	}
	
	public CRPDAO(String path) {
		this();
		this.path = path;
	}
	
	public void save(int[] score) {
		for(int i = 0; i < keys.length; i++) {
			prop.setProperty(keys[i], Integer.toString(score[i]));
		}
		
		File f = new File(path);
		try {
			prop.store(new FileWriter(f), "CRP Result");
		} catch (IOException e) {
			System.out.println("파일 입출력에 문제가 발생 했습니다.");
		}
	}
	
	public int[] load() {
		File f = new File(path);
		
		try {
			prop.load(new FileReader(f));
		} catch (IOException e) {
			System.out.println("파일 입출력에 문제가 발생 했습니다.");
		}
		
		int[] res = new int[3];
		
		// String[] keys = new String[] { "w", "l", "d" };
		for(int i = 0; i < keys.length; i++) {
			res[i] = Integer.parseInt(prop.getProperty(keys[i]));
		}
		return res;
	}
}
