package BrickBracker;

import javax.swing.JFrame;

public class main extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame obj1 = new JFrame();
		easyGamePlay gamePlay = new easyGamePlay();
		obj1.setBounds(50, 10, 700, 600);
		obj1.setTitle("Breakout Ball");
		obj1.setResizable(false);
		obj1.setVisible(true);
		obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj1.add(gamePlay);
		
		JFrame obj2 = new JFrame();
		hardGamePlay gamePlay1 = new hardGamePlay();
		obj2.setBounds(50, 10, 700, 600);
		obj2.setTitle("Breakout Ball");
		obj2.setResizable(false);
		obj2.setVisible(true);
		obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj2.add(gamePlay1);
		}

}
