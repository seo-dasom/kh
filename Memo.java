package com.kh.test;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class MemoWindow {
	private JFrame main;
	private JMenu m1;
	private String copyText;
	
	public MemoWindow() {
		init();
	}
	
	public void init() {
		
		main = new JFrame("메모장");
		main.setSize(700, 600);
		ImageIcon img = new ImageIcon("C:/Users/projava/eclipse-workspace/seodasom_repo/img/MemoImage.png");
		main.setIconImage(img.getImage());
		
		JTextArea textArea = new JTextArea("", 5, 10);
		textArea.setFont(new Font("", Font.PLAIN, 16));
		
		JScrollPane scrollBar = new JScrollPane(textArea);
		scrollBar.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		main.setJMenuBar(menuBar);
		menuBar.setBackground(Color.WHITE);
		
		main.add(scrollBar, "Center");
		
		m1 = new JMenu("파일");
		menuBar.add(m1);
		
		JMenuItem fileOpen = new JMenuItem("열기(O)");
		fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		JMenuItem fileNew = new JMenuItem("새로 만들기(N)");
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		JMenuItem fileSave =new JMenuItem("저장(S)");
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenuItem fileExit = new JMenuItem("종료(X)");
		fileExit.setMnemonic(KeyEvent.VK_X);
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		// 열기
		JFileChooser chooser = new JFileChooser();
		fileOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser.showOpenDialog(fileOpen);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					// System.out.println(file.getName() + "선택됨");
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(file));
						String text = "";
						while ((text = br.readLine()) != null) {
							textArea.append(text + "\r\n");
						}
						br.close();
					} catch (Exception e1) {
						System.out.println("열기오류" + e1);
					}
				}
			}
		});

		// 새로 만들기
		fileNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null
						, "새로운 메모를 하시겠습니까?\n(기존에 입력된 정보는 사라집니다.)"
						, "새로 만들기", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					textArea.setText("");
					main.setTitle("새로운 메모장");
				} else if ((result == JOptionPane.NO_OPTION) || (result == JOptionPane.CLOSED_OPTION)) {
					return;
				}
			}
		});
		
		// 저장
		JFileChooser chooser1 = new JFileChooser();
		fileSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser1.showSaveDialog(fileSave);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser1.getSelectedFile();
					// System.out.println(file.getName() + "선택됨");
					BufferedWriter bw = null;
					try {
						bw = new BufferedWriter(new FileWriter(file));
						bw.write(textArea.getText());
						bw.flush();
						bw.close();
					} catch (Exception e1) {
						System.out.println("저장오류" + e1);
					}
				}
			}
		});
		
		// 종료
		fileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"프로그램을 종료하시겠습니까?\n(기존 내용 저장x)",
						"프로그램 종료",
						JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if ((result == JOptionPane.NO_OPTION) || (result == JOptionPane.CLOSED_OPTION)) {
					return;
				}
			}
		});
		
		m1.add(fileOpen);
		m1.add(fileNew);
		m1.add(fileSave);
		m1.addSeparator();	// 구분선
		m1.add(fileExit);
		
		JMenu m2 = new JMenu("편집");
		menuBar.add(m2);
		
		JMenuItem copy = new JMenuItem("복사(C)");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		JMenuItem paste = new JMenuItem("붙여넣기(V)");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		JMenuItem cut = new JMenuItem("자르기(T)");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		
		JMenuItem del = new JMenuItem("삭제");
		del.setAccelerator(KeyStroke.getKeyStroke("F4"));
		
		JMenuItem date = new JMenuItem("날짜/시간");
		date.setAccelerator(KeyStroke.getKeyStroke("F5"));
		
		// 복사
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == copy) {
					copyText = textArea.getSelectedText();
				}
			}
		});
		
		// 붙여넣기
		paste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == paste) {
					int position = textArea.getCaretPosition();
					textArea.insert(copyText, position);
				}
			}
		});
		
		// 자르기 (자른내용 붙여넣기 가능)
		cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == cut) {
					copyText = textArea.getSelectedText();
					int start = textArea.getSelectionStart();
					int end = textArea.getSelectionEnd();
					textArea.replaceRange("", start, end);
				}
			}
		});
		
		// 삭제
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == del) {
					int start = textArea.getSelectionStart();
					int end = textArea.getSelectionEnd();
					textArea.replaceRange("", start, end);
				}
			}
		});
		
		// 날짜/시간
		date.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == date) {
					java.util.Date date = new java.util.Date();
					textArea.append(date.toLocaleString());
				}
			}
		});
		
		m2.add(copy);
		m2.add(paste);
		m2.add(cut);
		m2.add(del);
		m2.add(date);
		
		JMenu m3 = new JMenu("도움");
		menuBar.add(m3);
		
		JMenuItem calc = new JMenuItem("계산기(M)");
		calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		calc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == calc) {
					try {
						Runtime runtime = Runtime.getRuntime();
						runtime.exec("calc.exe");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JMenuItem paint = new JMenuItem("그림판(P)");
		paint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		paint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("mspaint.exe");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		m3.add(calc);
		m3.add(paint);
		
		// 어느 영역에서나 키입력 받음
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if(e.getID() == KeyEvent.KEY_PRESSED) {
				}
				return false;
			}
		});
	}
	
	public void show() {
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
}

public class Memo {

	public static void main(String[] args) {
		new MemoWindow().show();
	}

}
