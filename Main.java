package BrickBracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
	public static void level(String[] args) {
		JFrame Lf = new JFrame("Level");
		Lf.setSize(500,500);
		Lf.setLocationRelativeTo(null);
		Lf.setVisible(true);
		
		JButton easy = new JButton("EASY");
		easy.setBounds(200,100,100,40);
		Lf.add(easy);
		JButton hard = new JButton("HARD");
		hard.setBounds(200,250,100,40);
		Lf.add(hard);
		
	}
	
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		easyGamePlay gamePlay = new easyGamePlay();
		obj.setBounds(50, 10, 700, 600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
	}

}
