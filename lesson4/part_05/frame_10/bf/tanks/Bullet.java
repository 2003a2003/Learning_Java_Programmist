package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.Direction;
import lesson4.part_05.frame_10.bf.Destroyable;
import lesson4.part_05.frame_10.bf.Drawable;

import java.awt.*;

public class Bullet implements Drawable, Destroyable {

	private int speed = 5;
	
	private int x;
	private int y;
	private Direction direction;
	private AbstractTank tank;

	public AbstractTank getTank() {
		return tank;
	}

	public void setTank(AbstractTank tank) {
		this.tank = tank;
	}

	private boolean destroyed;

	public Bullet(int x, int y, Direction direction, AbstractTank tank) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
		this.tank = tank;
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
			g.setColor(new Color(8, 2, 6));
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
