package com.kh.exam6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 	이벤트(Event)
 * 		- 키보드나 마우스를 클릭하거나 움직이는 등의 동작을 이벤트라고 한다.
 * 		- 이벤트가 발생했을 때 이를 처리하기 위한 객체로 Event Listener
 * 		  또는 Event Adapter 가 있다.
 * 		- 대표적인 이벤트 종류
 * 			- ActionEvent	: 컴포넌트가 활성화될 때 발생하는 이벤트
 * 			- ContainerEvent: 컨테이너에 컴포넌트가 추가/삭제될 때 발생하는 이벤트
 * 			- FocusEvent	: 컴포넌트에 포커스가 들어오거나 나갈 때 발생하는 이벤트
 * 			- MouseEvent	: 마우스를 움직이거나 클릭할 때 발생하는 이벤트
 * 			- KeyEvent		: 키보드 입력에 의해 발생하는 이벤트
 * 			- WindowEvent	: 윈도우 창의 활성 및 비활성화에 의해 발생하는 이벤트
 * 
 * 	EventListener
 * 		- 발생 된 이벤트를 실질적으로 처리하기 위한 코드가 들어간다.
 * 		- 인터페이스로 구현되어 있다.
 * 
 * 	EventAdapter
 * 		- 발생 된 이벤트를 실질적으로 처리하기 위한 코드가 들어간다.
 * 		- 리스너를 상속받아 추상 클래스로 구현되어 있다.
 */

class EventWindow1 {
	private JFrame frm_main;
	private JLabel lbl_print;
	private JButton btn_event;
	
	public EventWindow1() {
		init();
		addEvent();
	}
	
	public void init() {
		frm_main = new JFrame("이벤트 테스트용");
		frm_main.setSize(250, 200);
		frm_main.setLayout(new BorderLayout());
		
		lbl_print = new JLabel("라벨 1");
		btn_event = new JButton("버튼 1");
		
		Dimension size = new Dimension(250, 50);
		lbl_print.setPreferredSize(size);
		
		frm_main.add(lbl_print, BorderLayout.NORTH);
		frm_main.add(btn_event, BorderLayout.CENTER);
	}
	
	private void addEvent() {
		// 익명 클래스로 이벤트 즉석 생성 및 처리 -> 리스너 인터페이스 사용
		btn_event.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// 컴포넌트에서 마우스를 눌렀다가 땠을 때 동작
				lbl_print.setText("마우스 릴리즈 이벤트 발생!");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// 컴포넌트에서 마우스를 누를 때 동작
				lbl_print.setText("마우스 프레스 이벤트 발생!" + e.getButton());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// 컴포넌트에서 빠져나갈 때 동작
				lbl_print.setText("마우스 Exited 이벤트 발생!");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// 컴포넌트에 진입할 때 동작
				lbl_print.setText("마우스 진입 이벤트 발생!");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// 컴포넌트에서 마우스 클릭할 때 동작
				lbl_print.setText("마우스 클릭 이벤트 발생!" + e.getX() + " | " + e.getY());
			}
		});
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setVisible(true);
	}
}

class EventWindow2 {
	private JFrame frm_main;
	private JLabel lbl_print;
	private JButton btn_event;
	
	public EventWindow2() {
		init();
		addEvent();
	}
	
	public void init() {
		frm_main = new JFrame("이벤트 테스트용");
		frm_main.setSize(250, 200);
		frm_main.setLayout(new BorderLayout());
		
		lbl_print = new JLabel("라벨 1");
		btn_event = new JButton("버튼 1");
		
		Dimension size = new Dimension(250, 50);
		lbl_print.setPreferredSize(size);
		
		frm_main.add(lbl_print, BorderLayout.NORTH);
		frm_main.add(btn_event, BorderLayout.CENTER);
	}
	
	private void addEvent() {
		// 익명 클래스로 이벤트 즉석 생성 및 처리 -> 어댑터 사용
		btn_event.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_print.setText(btn_event.getText() + "을 클릭하였습니다.");
			}
		});
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setVisible(true);
	}
}

class EventWindow3 {
	private JFrame frm_main;
	private JLabel lbl_print;
	private JButton btn_event;
	
	public EventWindow3() {
		init();
		addEvent();
	}
	
	public void init() {
		frm_main = new JFrame("이벤트 테스트용");
		frm_main.setSize(250, 200);
		frm_main.setLayout(new BorderLayout());
		
		lbl_print = new JLabel("라벨 1");
		btn_event = new JButton("버튼 1");
		
		Dimension size = new Dimension(250, 50);
		lbl_print.setPreferredSize(size);
		
		frm_main.add(lbl_print, BorderLayout.NORTH);
		frm_main.add(btn_event, BorderLayout.CENTER);
	}
	
	private class BtnClickAdapter extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			lbl_print.setText("버튼 클릭 이벤트 발생!!");
		}
	}
	
	private void addEvent() {
		// 내부 클래스로 생성 및 처리
		btn_event.addMouseListener(new BtnClickAdapter());
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setVisible(true);
	}
}

// 독립적인 클래스로 생성 및 처리
class BtnClickAdapter extends MouseAdapter {
	private JLabel lbl_print;
	
	public BtnClickAdapter(JLabel label) {
		lbl_print = label;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		lbl_print.setText("버튼 클릭 이벤트 발생!!");
	}
}

class EventWindow4 {
	private JFrame frm_main;
	private JLabel lbl_print;
	private JButton btn_event;
	
	public EventWindow4() {
		init();
		addEvent();
	}
	
	public void init() {
		frm_main = new JFrame("이벤트 테스트용");
		frm_main.setSize(250, 200);
		frm_main.setLayout(new BorderLayout());
		
		lbl_print = new JLabel("라벨 1");
		btn_event = new JButton("버튼 1");
		
		Dimension size = new Dimension(250, 50);
		lbl_print.setPreferredSize(size);
		
		frm_main.add(lbl_print, BorderLayout.NORTH);
		frm_main.add(btn_event, BorderLayout.CENTER);
	}
	
	private void addEvent() {
		btn_event.addMouseListener(new BtnClickAdapter(lbl_print));
	}
	
	public void show() {
		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_main.setVisible(true);
	}
}

public class Sample6 {

	public static void main(String[] args) {
		new EventWindow4().show();
	}

}
