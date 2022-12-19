package 찐막이다_진짜;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class hardGamePlay extends JFrame implements KeyListener, ActionListener{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private boolean play = false;
		private int score = 0;
		private int totalBricks = 40;
		private int playerX = 300;
		private int x_pos = 100;
		private int y_pos = 350;
		private int x_dir = -1;
		private int y_dir = -2;
		private MapGenerator hardmap;
		
		public hardGamePlay() {
			hardmap = new MapGenerator(5, 8);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
		}
		public void paint(Graphics g) {
			//background
			g.setColor(Color.black);
			g.fillRect(1, 1, 692, 592);
			//map
			hardmap.draw((Graphics2D) g);
			// the scores
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("" + score, 590, 30);
			//paddle
			g.setColor(Color.green);
			g.fillRect(playerX, 550, 100, 8);
			//ball
			g.setColor(Color.yellow);
			g.fillOval(x_pos, y_pos, 20, 20);
			if (totalBricks <= 0) {
				play = false;
				x_dir = 0;
				y_dir = 0;
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("블록을 모두 제거하였습니다 ", 190, 300);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Enter키를 눌러 다시 시작하세요. ", 230, 350);
			}
			if (y_pos > 570) {
				play = false;
				x_dir = 0;
				y_dir = 0;
				g.setColor(Color.red);
				g.setFont(new Font("serif", Font.BOLD, 30));
				g.drawString("모든 블록을 제거하지 못했습니다.", 190, 300);
				g.setFont(new Font("serif", Font.BOLD, 20));
				g.drawString("Enter키를 눌러 다시 시작하세요.  ", 230, 350);
			}
			g.dispose();
		}
		public void actionPerformed(ActionEvent e) {
			if (play) {
				if (new Rectangle(x_pos, y_pos, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {  //블록 만들기
					y_dir = -y_dir;
				}
					A: for (int i = 0; i < hardmap.map.length; i++) {
						for (int j = 0; j < hardmap.map[0].length; j++) {
							if (hardmap.map[i][j] > 0) {
								int brickX = j * hardmap.brickWidth + 80;
								int brickY = i * hardmap.brickHeight + 50;
								int brickWidth = hardmap.brickWidth;
								int brickHeight = hardmap.brickHeight;
								Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
								Rectangle ballRect = new Rectangle(x_pos, y_pos, 20, 20);
								Rectangle brickRect = rect;
							if (ballRect.intersects(brickRect)) {
								hardmap.setBrickValue(0, i, j);
								totalBricks--;
								score += 5;
								if (x_pos + 19 <= brickRect.x || x_pos + 1 >= brickRect.x + brickRect.width) {
									x_dir = -x_dir;
								} else {
									y_dir = -y_dir;
								}
								break A;
							}}}}
					x_pos += x_dir;
					y_pos += y_dir;
					if (x_pos < 0) {
						x_dir = -x_dir;
					}
					if (y_pos < 0) {
						y_dir = -y_dir;
					}
					if (x_pos > 670) {
						x_dir = -x_dir;
					}
			}
			repaint();
	}
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (playerX >= 600) {
					playerX = 600;
				} else {
					moveRight();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (playerX < 10) {
					playerX = 10;
				} else {
					moveLeft();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (!play) {
					play = true;
					x_pos = 100;
					y_pos = 350;
					x_dir = -1;
					y_dir = -2;
					score = 0;
					totalBricks = 40;
					hardmap = new MapGenerator(5, 8);
					repaint();
				}
			}
		}
		public void moveRight() {
			play = true;
			playerX += 20;
		}
		public void moveLeft() {
			play = true;
			playerX -= 20;
		}
	@Override
		public void keyReleased(KeyEvent e) {
	//TODO Auto-generated method stub
		}
	@Override
		public void keyTyped(KeyEvent e) {
	//TODO Auto-generated method stub
		}
	public void start() {
		// TODO 자동 생성된 메소드 스텁
		
	}
	}