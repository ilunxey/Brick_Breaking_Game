package brickBracker_A;

import javax.swing.JFrame;

public class Main_A {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay_A gamePlay = new Gameplay_A();
		obj.setBounds(50, 10, 700, 600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
	}
}