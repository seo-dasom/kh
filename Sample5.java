package com.kh.exam5;

import java.awt.*;
import javax.swing.*;

class LoginWindow {
	private JFrame frm;
	
	public LoginWindow() {
		init();
	}
	
	public void init() {
		frm = new JFrame("Login");
		frm.setSize(new Dimension(360, 120));
		frm.setLayout(new BorderLayout());
		
		JPanel pan_input = new JPanel(new BorderLayout());
		JPanel pan_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
		frm.add(pan_input, BorderLayout.NORTH);
		frm.add(pan_button, BorderLayout.CENTER);
		
		JPanel pan_user = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JPanel pan_pass = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		pan_input.add(pan_user, BorderLayout.NORTH);
		pan_input.add(pan_pass, BorderLayout.CENTER);
		
		JLabel lbl_username = new JLabel("Username :");
		JTextField txt_username = new JTextField();
		JLabel lbl_password = new JLabel("Password :");
		JTextField txt_password = new JTextField();
		
		pan_user.add(lbl_username);	pan_user.add(txt_username);
		pan_pass.add(lbl_password);	pan_pass.add(txt_password);
		
		JButton btn_login = new JButton("Login");
		JButton btn_cancel = new JButton("Cancel");
		pan_button.add(btn_login);	pan_button.add(btn_cancel);
		
		Dimension s = txt_username.getPreferredSize();
		s.setSize(275, s.getHeight());
		txt_username.setPreferredSize(s);
		txt_password.setPreferredSize(s);
		
	}
	
	public void show() {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		frm.setVisible(true);
	}
}

class CalculatorWindow {
	private JFrame calf;
	
	public CalculatorWindow() {
		init();
	}
	
	public void init() {
		calf = new JFrame("계산기");
		calf.setSize(new Dimension(270, 400));
		calf.setLayout(new GridLayout(6, 4));
		
		TextField input = new TextField();
//		calf.add(new JButton("MC"));
//		calf.add(new JButton("MR"));
//		calf.add(new JButton("M+"));
//		calf.add(new JButton("M-"));
//		calf.add(new JButton("MS"));
//		calf.add(new JButton("M^"));
		calf.add(new JButton("%"));
		calf.add(new JButton("√"));
		calf.add(new JButton("x2"));
		calf.add(new JButton("1/x"));
		calf.add(new JButton("CE"));
		calf.add(new JButton("C"));
		calf.add(new JButton("<-"));
		calf.add(new JButton("÷"));
		calf.add(new JButton("7"));
		calf.add(new JButton("8"));
		calf.add(new JButton("9"));
		calf.add(new JButton("×"));
		calf.add(new JButton("4"));
		calf.add(new JButton("5"));
		calf.add(new JButton("6"));
		calf.add(new JButton("-"));
		calf.add(new JButton("1"));
		calf.add(new JButton("2"));
		calf.add(new JButton("3"));
		calf.add(new JButton("+"));
		calf.add(new JButton("±"));
		calf.add(new JButton("0"));
		calf.add(new JButton("."));
		calf.add(new JButton("="));
		
		
		JTextField txt = new JTextField();
		
		txt.setText("0");
		
	}
	
	public void show() {
		calf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calf.setResizable(false);
		calf.setVisible(true);
	}
}

public class Sample5 {

	public static void main(String[] args) {
		CalculatorWindow cal = new CalculatorWindow();
		cal.show();
		
//		LoginWindow lo = new LoginWindow();
//		lo.show();
	}

}
