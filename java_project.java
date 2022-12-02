package java_project;

import javax.swing.JPanel;


public class java_project {
	public class Box {
		private int box_size;
		public Box(int size) { box_size = size; }
		public boolean inHorizontalContact(int x_position) {
		return x_position <=0 || x_position >= box_size;
		}
		public boolean inVerticalContact(int y_position) {
		return y_position <=0 || y_position >= box_size;
		}
		public int sizeOf() { return box_size; }
		}
	public class MovingBall
	{
		private int x_pos, y_pos, radius;
		private int x_velocity = 5;
		private int y_velocity = 2;
		private Box container;
		public MovingBall(int x, int y, int r, Box box) {
			x_pos=x; y_pos=y; radius=r; container=box;
		}
		public int xPosition() { return x_pos; }
		public int yPosition() { return y_pos; }
		public int radiusOf() { return radius; }
		public void move(int time_units) {
			x_pos = x_pos + x_velocity * time_units;
				if(container.inHorizontalContact(x_pos))
					x_velocity = -x_velocity;
					y_pos = y_pos + y_velocity * time_units;
				if(container.inVerticalContact(y_pos))
					y_velocity = -y_velocity;
			}
	
	}
	
	
	public class AnimationWriter extends JPanel
	{ 
	 private class BoxWriter box_writer; // the output-view of the box
	 private class BallWriter ball_writer; // the output-view of the ball in the box
	 /** Constructor AnimationWriter constructs the view of box and ball
	 * @param b - the box's writer
	 * @param l - the ball's writer
	 * @param size - the frame's size */
	 public class AnimationWriter(BoxWriter b, BallWriter l, int size)
	 { 
	 box_writer = b;
	 ball_writer = l;
	 JFrame my_frame = new JFrame();
	 my_frame.getContentPane().add(this);
	 my_frame.setTitle("Bounce");
	 my_frame.setSize(size, size);
	 my_frame.setVisible(true);
	 }
	 /** paintComponent paints the box and ball
	 * @param g - the graphics pen */
	 public void paintComponent(Graphics g)
	 { 
	 box_writer.paint(g);
	 ball_writer.paint(g);
	 }
	}
	public class BallWriter
	{ private MovingBall ball; // the (address of the) ball object displayed
	 private Color balls_color; // the ball's color
	 /** Constructor BallWriter
	 * @param x - the ball to be displayed
	 * @param c - its color */
	 public BallWriter(MovingBall x, Color c)
	 { ball = x;
	 balls_color = c;
	 }
	 /** paint paints the ball on the view
	 * @param g - the graphics pen used to paint the ball */
	 public void paint(Graphics g)
	 { g.setColor(balls_color);
	 int radius = ball.radiusOf();
	 g.fillOval(ball.xPosition() - radius,
	 ball.yPosition() - radius, radius * 2, radius * 2);
	 }
	}
	public class BoxWriter
	{
	private Box box; // the (address of the) box object that is displayed
	 /** Constructor BoxWriter displays the box
	 * @param b - the box that is displayed */
	 public BoxWriter(Box b){
		 box = b; 
		 }
	 /** paint paints the box
	 * @param g - the graphics pen used to paint the box */
	 public void paint(Graphics g){
	 int size = box.sizeOf();
	 g.setColor(Color.white);
	 g.fillRect(0, 0, size, size);
	 g.setColor(Color.black);
	 g.drawRect(0, 0, size, size);
	 }
	}
	public class BounceController {
		private MovingBall ball; // model object
		private AnimationWriter writer; // output-view object
		public BounceController(MovingBall b, AnimationWriter w)
		{ ball = b; writer=w; }
		public void runAnimation() {
		int time_unit = 1;
		int painting_delay = 20;
		while (true)
		{
		delay(painting_delay);
		ball.move(time_unit);
		writer.repaint();
		}
		}
		private void delay(int how_long) {
		try { Thread.sleep(how_long); } catch (InterruptedException e) { }
		}
	}
}
