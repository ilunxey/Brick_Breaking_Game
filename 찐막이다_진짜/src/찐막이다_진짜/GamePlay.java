package 찐막이다_진짜;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GamePlay extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/STARTBUTTON_BASIC.png"));
	private ImageIcon startButtonPussImage = new ImageIcon(Main.class.getResource("../images/STARTBUTTON_PUSS.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/EASY.png"));
	private ImageIcon easyButtonPussImage = new ImageIcon(Main.class.getResource("../images/EASY_PUSS.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/HARD.png"));
	private ImageIcon hardButtonPussImage = new ImageIcon(Main.class.getResource("../images/HARD_PUSS.png"));
	
	private Image start_image = new ImageIcon(Main.class.getResource("../images/start_image (3).jpg")).getImage();
	private Image level_image = new ImageIcon(Main.class.getResource("../images/level_screen.jpg")).getImage();
	
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardtButton = new JButton(hardButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
		
	public GamePlay() {
		setUndecorated(true);
		setTitle("Brick_Brack");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		easyButton.setVisible(false);
		hardtButton.setVisible(false);
		
		startButton.setBounds(690, 250, 500, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonPussImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//게임 시작 이벤트
				startButton.setVisible(false);
				easyButton.setVisible(true);
				hardtButton.setVisible(true);
				start_image = new ImageIcon(Main.class.getResource("../images/level_screen.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		easyButton.setBounds(130, 150, 500, 500);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonPussImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//이지모드 이벤트
			}
		});
		add(easyButton);
		
		hardtButton.setBounds(640, 150, 500, 500);
		hardtButton.setBorderPainted(false);
		hardtButton.setContentAreaFilled(false);
		hardtButton.setFocusPainted(false);
		hardtButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardtButton.setIcon(hardButtonPussImage);
				hardtButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardtButton.setIcon(hardButtonBasicImage);
				hardtButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//하드 모드 이벤트
			}
		});
		add(hardtButton);
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(start_image, 0, 0, null);
		//if(isMainScreen)
		//{
			//g.drawImage(selectedImage, 340, 100, null);
		//}
		paintComponents(g);
		this.repaint();
	}
	
	

}
