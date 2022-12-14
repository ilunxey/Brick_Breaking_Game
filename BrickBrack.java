package BrickBracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class BrickBrack extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BrickBrack() {
		
		setTitle("BrickBracker Game");
		
		JButton easy = new JButton("EASY");
		JButton hard = new JButton("HARD");
		
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		add(easy);
		add(hard);
		setSize(700,700);
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width)/2,
					 (windowSize.height - frameSize.height)/2); //화면 중앙 띄우기
		setLayout(null);
		
		easy.setBounds(290,200,100,40);
		hard.setBounds(290,400,100,40);
		
		setResizable(false);
		setVisible(true);
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame obj = new JFrame();
				new easyGamePlay();
				obj.setBounds(50, 10, 700, 700);
				obj.setTitle("BrickBracker-Easy");
				obj.setResizable(false);
				obj.setVisible(true);	
			}
		});
		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame obj = new JFrame();
				new hardGamePlay();
				obj.setBounds(50, 10, 700, 700);
				obj.setTitle("BrickBracker-Hard");
				obj.setResizable(false);
				obj.setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		new BrickBrack();
	}
}
