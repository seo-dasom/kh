package com.kh.exam3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

/*
 * 	GUI를 사용하여 Local PC의 파일 또는 디럭터리의 정보를 보여주는 프로그램
 * 	모든 내용은 라벨에 작성.
 */

class MainWindow {
	private JFrame frm_main;
	private ArrayList<JLabel> lblList;
	
	public MainWindow() {
		init();
	}
	
	private void init() {
		frm_main = new JFrame("Local PC");
		frm_main.setSize(500, 400);
		frm_main.setLayout(new BoxLayout(frm_main.getContentPane(), BoxLayout.Y_AXIS));
		
		lblList = new ArrayList<>();
	}
	
	public void addLabel(String text) {
		JLabel lbl = new JLabel(text);
		lblList.add(lbl);
		frm_main.add(lbl);
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setVisible(true);
	}
}

public class Sample3 {

	public static void main(String[] args) {
		MainWindow w = new MainWindow();
		File f = new File("C:/Users/projava/eclipse-workspace");
		if(f.exists()) {
			w.addLabel("절대 경로 : " + f.getAbsolutePath());
			w.addLabel("파일/디렉터리 : " + (f.isFile() ? "파일 " : "디렉터리"));
			w.addLabel("숨김 : " + (f.isHidden() ? "예" : "아니오"));
			w.addLabel("읽기 : " + (f.canRead() ? "예" : "아니오"));
			w.addLabel("쓰기 : " + (f.canWrite() ? "예" : "아니오"));
			w.addLabel("실행 : " + (f.canExecute() ? "예" : "아니오"));
			if(f.isFile()) {
				w.addLabel("파일 크기 : " + f.length() + "바이트 (" + (f.length() / 1024) + "KB)");
			}
			w.addLabel("수정일 : " + new SimpleDateFormat("YYYY년 MM월 dd일 a hh시 mm분 ss초")
					.format(new Date(f.lastModified())));
		} else {
			w.addLabel("해당 파일 및 디렉터리가 존재하지 않습니다.");
		}
		
		w.show();
	}

}
