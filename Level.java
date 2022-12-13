package BrickBracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Level extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Level(String[] args) {
		JFrame Lf = new JFrame("Level");
		Lf.setSize(500,500);
		Lf.setLocationRelativeTo(null);
		JButton easy = new JButton("EASY");
		easy.setBounds(200,100,100,40);
		JButton hard = new JButton("HARD");
		hard.setBounds(200,250,100,40);
		
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Lf.add(easy);
		Lf.add(hard);
		Lf.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
