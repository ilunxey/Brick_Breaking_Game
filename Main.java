package newBrickbracker;


import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
		public static void main(String[] args) {
			JFrame obj=new JFrame();
			GamePlay gamePlay = new GamePlay();
			obj.setBounds(10, 10, 700, 600);
			obj.setTitle("Breakout Ball");
			obj.setResizable(false);
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gamePlay);
			obj.setVisible(true);
			
			JFrame f1 = new JFrame();
			JButton b1 = new JButton("EASY");
			b1.setBounds(100,100,100,40);
			JButton b2 = new JButton("HARD");
			b2.setBounds(100,100,100,100);
			
			f1.add(b1,b2);
			f1.setSize(300,400);
			f1.setLayout(null);
			f1.setVisible(true);
			
			
			}
	}

