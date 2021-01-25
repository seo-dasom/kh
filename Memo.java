package com.kh.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainWindow {
	private JFrame main;
	private JMenu m1;
	
	public MainWindow() {
		init();
	}
	
	public void init() {
		main = new JFrame("메모장");
		main.setSize(700, 600);
		
		JTextArea textArea = new JTextArea("", 5, 10);
		
		JScrollPane scrollBar = new JScrollPane(textArea);
		scrollBar.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		main.setJMenuBar(menuBar);
		
		main.add(scrollBar, "Center");
		
		m1 = new JMenu("파일");
		menuBar.add(m1);
		m1.add(new JMenuItem("새로 만들기(N)"));
		m1.getItem(0).setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		m1.add(new JMenuItem("저장(S)"));
		m1.getItem(1).setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		m1.add(new JMenuItem("새 창(N)"));
		//m1.getItem(2).setAccelerator(KeyStroke.getKey('N', InputEvent.CTRL_MASK, InputEvent.SHIFT_MASK));
		//m1.addSeparator();
		m1.add(new JMenuItem("종료(X)"));
		m1.getItem(3).setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_MASK));
		
		m1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"프로그램을 종료하시겠습니까?",
						"프로그램 종료",
						JOptionPane.YES_NO_OPTION);
				if(result == 0) {
					System.exit(0);
				}
			}
		});
		
		JMenu m2 = new JMenu("편집");
		menuBar.add(m2);
		m2.add(new JMenuItem("복사(C)"));
		m2.getItem(0).setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
		m2.add(new JMenuItem("붙여넣기(V)"));
		m2.getItem(1).setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
		
		JMenu m3 = new JMenu("도움말");
		menuBar.add(m3);
		m3.add(new JMenuItem("메모장 정보"));
		
	}
	
	public void show() {
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
}
public class Memo {

	public static void main(String[] args) {
		new MainWindow().show();
	}

}
