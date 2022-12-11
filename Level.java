package BrickBracker;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Level extends easyGamePlay{
	public static void main(String[] args) {
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
}
