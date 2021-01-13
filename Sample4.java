package com.kh.exam4;

import java.io.*;

public class Sample4 {

	public static void main(String[] args) {
		// FileInputStream + InputStreamReader
		// 바이트 기반 	+ 문자보조
		try {
			File f = new File("C:/Sample.txt");
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			
			String s = "";
			int read;
			char[] cArr = new char[16];
			while((read = isr.read(cArr)) != -1) {
				if(read == cArr.length) {
					s += new String(cArr);
				} else {
					s += new String(cArr, 0, read);
				}
			}
			System.out.println(s);
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// FileOutputStream + OutputStreamWriter
		// 바이트 기반 	+ 문자보조
		try {
			File f = new File("C:/Sample.txt");
			FileOutputStream fos = new FileOutputStream(f, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
					
			osw.write("문자열을 입력하여 파일 쓰기\n");
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// FileReader + BufferedReader
		// 문자 기반 + 버퍼 보조
		try {
			File f = new File("C:/Sample.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			while(br.ready()) {
				sb.append(br.readLine() + "\n");
			}
			System.out.print(sb.toString());
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// FileWriter + BufferedWriter
		// 문자 기반 + 버퍼 보조
		try {
			File f = new File("C:/Sample.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("문자 기반 스트림 + 버퍼 보조(BufferedWriter)");
			bw.newLine();
			bw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
