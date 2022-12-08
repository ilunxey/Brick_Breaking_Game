package newBrickbracker;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		public static void main(String[] args) {
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
		public void keyReleased(KeyEvent e) {}
		public void moveRight(){
			play = true;
			playerX+=10;
		}
		public void moveLeft(){
			play = true;
			playerX-=10;
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
		//Rectangle과 new Rectangle이 교차할지 결정함 아니 근데 넘 모르겠다 여기
		public void actionPerformed(ActionEvent e){
			if(play){
				if(new Rectangle(x_pos, y_pos, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8))){
					y_dir = -y_dir;
					x_dir = -2;
				}else if(new Rectangle(x_pos, y_pos, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8))){
					y_dir = -y_dir;
					x_dir = x_dir + 1;
				}else if(new Rectangle(x_pos, y_pos, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8))){
					y_dir = -y_dir;
				}
				// check map collision with the ball
				A: for(int i = 0; i<map.map.length; i++){
					for(int j =0; j<map.map[0].length; j++){
						if(map.map[i][j] > 0){
							//scores++;
							int brickX = j * map.brickWidth + 80;
							int brickY = i * map.brickHeight + 50;
							int brickWidth = map.brickWidth;
							int brickHeight = map.brickHeight;
							Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
							Rectangle ballRect = new Rectangle(x_pos, y_pos, 20, 20);
							Rectangle brickRect = rect;
						if(ballRect.intersects(brickRect)){
							map.setBrickValue(0, i, j);
							score+=10;
							totalBricks--;
				// when ball hit right or left of brick
						if(x_pos + 19 <= brickRect.x || x_pos + 1 >= brickRect.x + brickRect.width){
							x_dir = -x_dir;
						}
						// when ball hits top or bottom of brick
						else{
							y_dir = -y_dir;
						}
						break A;
						}
						}
					}
				}
				x_dir += x_dir;
				y_dir += y_dir;
				if(x_pos < 0){
					x_dir = -x_dir;
				}
				if(y_pos < 0){
					y_dir = -y_dir;
				}
				if(x_pos > 670){
					x_dir = -x_dir;
				}
				repaint();
			
			}
		}
}
