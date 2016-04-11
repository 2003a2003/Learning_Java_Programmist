package lesson4.part_05.frame_10.bf.tanks;

import lesson4.part_05.frame_10.bf.Destroyable;
import lesson4.part_05.frame_10.bf.Drawable;
import lesson4.part_05.frame_10.Direction;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

	public void turn(Direction direction);

}
