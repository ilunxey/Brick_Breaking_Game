package 찐막이다_진짜;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Brick_Brack extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/STARTBUTTON_BASIC.png"));
	private ImageIcon startButtonPussImage = new ImageIcon(Main.class.getResource("../images/STARTBUTTON_PUSS.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/EASY.png"));
	private ImageIcon easyButtonPussImage = new ImageIcon(Main.class.getResource("../images/EASY_PUSS.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/HARD.png"));
	private ImageIcon hardButtonPussImage = new ImageIcon(Main.class.getResource("../images/HARD_PUSS.png"));
	
	private Image start_image = new ImageIcon(Main.class.getResource("../images/start_image (3).jpg")).getImage();
	
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false; //현재 게임으로 넘어왔는지에 관한 변수
		
	public static easyGamePlay easyGamePlay;
	public static hardGamePlay hardGamePlay;
	
	public Brick_Brack() {
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
		hardButton.setVisible(false);
		
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
				hardButton.setVisible(true);
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
				gameStart_easy("easy");
			}
		});
		add(easyButton);
		
		hardButton.setBounds(640, 150, 500, 500);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonPussImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//하드 모드 이벤트
				gameStart_hard("hard");
			}
		});
		add(hardButton);
		
		init();
		
	}
	private void init() {
		addKeyListener(new KeyListener());
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(start_image, 0, 0, null);
		if(isMainScreen) {
			
		}
		if(isGameScreen) {
			
		}
		paintComponents(g);
		this.repaint();
	}
	
	public void gameStart_easy(String difficulty) {
		isMainScreen = false;
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		start_image = new ImageIcon(Main.class.getResource("../images/game_screen.jpg")).getImage();
		//isGameScreen(true);
		setFocusable(true);
		easyGamePlay.start();
	}
	
	public void gameStart_hard(String difficulty) {
		isMainScreen = false;
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		start_image = new ImageIcon(Main.class.getResource("../images/game_screen.jpg")).getImage();
		//isGameScreen(true);
		setFocusable(true);
		hardGamePlay.start();
	}
}
