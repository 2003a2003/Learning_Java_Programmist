package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.Direction;
import lesson5.part_05.frame_05.bf.Destroyable;
import lesson5.part_05.frame_05.bf.Drawable;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move() throws Exception;

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
