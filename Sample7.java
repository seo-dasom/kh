package com.kh.exam7;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class CalcWindow {
	private JFrame frm_main;
	private JLabel lbl_print;
	private HashMap<String, JButton> hmButtons = new HashMap<>();
	private double num1, num2;
	private String oper;
	private Font font = new Font("맑은고딕", Font.PLAIN, 24);
	
	public CalcWindow() {
		init();
		addEvent();
	}
	
	private void createNumberButton() {
		for(int i = 0; i < 10; i++) {
			hmButtons.put(Integer.toString(i), new JButton(Integer.toString(i)));
			hmButtons.get(Integer.toString(i)).setFont(font);
		}
		hmButtons.put("±", new JButton("±"));
		hmButtons.put(".", new JButton("."));
		hmButtons.put("+", new JButton("+"));
		hmButtons.put("-", new JButton("-"));
		hmButtons.put("×", new JButton("×"));
		hmButtons.put("=", new JButton("="));
		hmButtons.put("÷", new JButton("÷"));
		hmButtons.put("CE", new JButton("CE"));
		hmButtons.put("C", new JButton("C"));
		hmButtons.put("◁", new JButton("◁"));
	}
	
	public void init() {
		frm_main = new JFrame("계산기");
		frm_main.setSize(350, 500);
		frm_main.setLayout(new BorderLayout());
		
		JPanel pan_numPad = new JPanel(new GridLayout(5, 4, 3, 3));
		frm_main.add(pan_numPad, BorderLayout.CENTER);
		createNumberButton();
		
		pan_numPad.add(hmButtons.get("CE"));
		pan_numPad.add(hmButtons.get("C"));
		pan_numPad.add(hmButtons.get("◁"));
		pan_numPad.add(hmButtons.get("÷"));
		
		pan_numPad.add(hmButtons.get("7"));
		pan_numPad.add(hmButtons.get("8"));
		pan_numPad.add(hmButtons.get("9"));
		pan_numPad.add(hmButtons.get("×"));
		
		pan_numPad.add(hmButtons.get("4"));
		pan_numPad.add(hmButtons.get("5"));
		pan_numPad.add(hmButtons.get("6"));
		pan_numPad.add(hmButtons.get("-"));
		
		pan_numPad.add(hmButtons.get("1"));
		pan_numPad.add(hmButtons.get("2"));
		pan_numPad.add(hmButtons.get("3"));
		pan_numPad.add(hmButtons.get("+"));
		
		pan_numPad.add(hmButtons.get("±"));
		pan_numPad.add(hmButtons.get("0"));
		pan_numPad.add(hmButtons.get("."));
		pan_numPad.add(hmButtons.get("="));
		
		lbl_print = new JLabel("0");
		lbl_print.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbl_print.setPreferredSize(new Dimension(250, 50));
		
		frm_main.add(lbl_print, BorderLayout.NORTH);
	}
	
	// 내부 클래스로 생성 및 처리
	private class BtnClickAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			lbl_print.setText(lbl_print.getText() + btn.getText());
		}
	}
	
	private class BtnOperAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("=")) {
				switch(oper) {
					case "+":
						lbl_print.setText("" + (num1 + Double.parseDouble(lbl_print.getText())));
						break;
					case "-":
						lbl_print.setText("" + (num1 - Double.parseDouble(lbl_print.getText())));
						break;
					case "×":
						lbl_print.setText("" + (num1 * Double.parseDouble(lbl_print.getText())));
						break;
					case "÷":
						lbl_print.setText("" + (num1 / Double.parseDouble(lbl_print.getText())));
						break;
				}
			}
			num1 = Double.parseDouble(lbl_print.getText());
			oper = btn.getText();
			lbl_print.setText("");
		}
	}
	
	private void addEvent() {
		for(int i = 0; i < 10; i++) {
			hmButtons.get(Integer.toString(i)).addMouseListener(new BtnClickAdapter());
		}
		hmButtons.get("+").addMouseListener(new BtnOperAdapter());
		hmButtons.get("-").addMouseListener(new BtnOperAdapter());
		hmButtons.get("×").addMouseListener(new BtnOperAdapter());
		hmButtons.get("÷").addMouseListener(new BtnOperAdapter());
		hmButtons.get("=").addMouseListener(new BtnOperAdapter());
		
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setResizable(false);
		frm_main.setVisible(true);
	}
}

public class Sample7 {

	public static void main(String[] args) {
		new CalcWindow().show();
	}

}
