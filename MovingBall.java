package newBrickbracker;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MovingBall {
	private int x_pos, y_pos;
	private int x_velocity = 5;
	private int y_velocity = 2;
	private Box container;
	public class Box {
		private int box_size;
		public Box(int size) { box_size = size; }
		public boolean inHorizontalContact(int x_position) {
			return x_position <=0 || x_position >= box_size;
		}
		public boolean inVerticalContact(int y_position) {
			return y_position <=0 || y_position >= box_size;
		}
		public int sizeOf(){ 
			return box_size; 
		}
	}
	public MovingBall(int x, int y, int r, Box box) {
	x_pos=x; y_pos=y; container=box;
	}
	//공의 위치
	public int xPosition(){ 
		return x_pos; 
	}
	public int yPosition() {
		return y_pos; 
	}
	//공이 운동
	public void move(int time_units) {
		x_pos = x_pos + x_velocity * time_units;
	if(container.inHorizontalContact(x_pos))
		x_velocity = -x_velocity;
		y_pos = y_pos + y_velocity * time_units;
	if(container.inVerticalContact(y_pos))
		y_velocity = -y_velocity;
	}
	public void paint(Graphics g) {
		//ball
		g.setColor(Color.YELLOW);
		g.fillRect(x_pos, x_velocity, x_pos, y_velocity);
	}
	
}
