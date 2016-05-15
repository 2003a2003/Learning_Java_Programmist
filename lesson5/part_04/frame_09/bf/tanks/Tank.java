package lesson5.part_04.frame_09.bf.tanks;

import lesson5.part_04.frame_09.Direction;
import lesson5.part_04.frame_09.bf.Destroyable;
import lesson5.part_04.frame_09.bf.Drawable;

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
