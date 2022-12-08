package newBrickbracker;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamePlay extends JPanel implements KeyListener, ActionListener{
	private boolean play = false;
	private int score = 0;
	private int totalBricks = 40;
	private int playerX = 310;
	private int x_pos = 150;
	private int y_pos = 400;
	private int x_dir = -1;
	private int y_dir = -2;
	private MapGenerator map;
		public GamePlay() {
			map = new MapGenerator(4, 10);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
		}
		public void paint(Graphics g) {
			// background
			g.setColor(Color.black);
			g.fillRect(1, 1, 692, 592);
			// drawing map
			map.draw((Graphics2D) g);
			// borders
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 3, 592);
			g.fillRect(0, 0, 692, 3);
			g.fillRect(691, 0, 3, 592);
			// the scores
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 25));
			g.drawString(""+score, 590,30);
			// the timer
			g.setColor(Color.RED);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("Time Over", 260,300);
			//paddle
			g.setColor(Color.blue);
			g.fillOval(x_pos, y_pos, 20, 20);

			//게임 결과
			// when you won the game
			if(totalBricks <= 0){
				play = false;
				x_dir = 0;
				y_dir = 0;
				g.setColor(Color.RED);
				g.setFont(new Font("serif",Font.BOLD, 30));
				g.drawString("You Won", 260,300);
				g.setColor(Color.RED);
				g.setFont(new Font("serif",Font.BOLD, 20));
				g.drawString("Press (Enter) to Restart", 230,350);
			}
			// when you lose the game
			if(y_pos > 570){
				play = false;
				x_dir = 0;
				y_dir = 0;
				g.setColor(Color.RED);
				g.setFont(new Font("serif",Font.BOLD, 30));
				g.drawString("Game Over, Scores: "+score, 190,300);
				g.setColor(Color.RED);
				g.setFont(new Font("serif",Font.BOLD, 20));
				g.drawString("Press (Enter) to Restart", 230,350);
			}
			g.dispose();
		}
		public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT){	
					if(playerX >= 600){
						playerX = 600;
					}else{
						moveRight();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT){
					if(playerX < 10){
						playerX = 10;
					}else{
						moveLeft();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if(!play){
						play = true;
						x_pos = 150;
						y_pos = 400;
						x_dir = -1;
						y_dir = -2;
						playerX = 310;
						score = 0;
						totalBricks = 40;
						map = new MapGenerator(4, 10);
						repaint();
					}
			}
		}
	}
