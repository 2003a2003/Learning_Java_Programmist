package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.bf.Destroyable;
import lesson4.part_05.frame_10.bf.Drawable;
import lesson4.part_05.frame_10.Direction;

import java.awt.*;

public class Bullet implements Drawable, Destroyable {

	private int speed = 5;
	
	private int x;
	private int y;
	private Direction direction;

	private boolean destroyed;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!destroyed) {
			g.setColor(new Color(90, 255, 71));
			g.fillRect(this.x, this.y, 14, 14);
		}
	}
	
	public void destroy() {
		destroyed = true;
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public int getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
