package lesson6.part_04.frame_05.bf.tanks;

import lesson6.part_04.frame_05.Direction;
import lesson6.part_04.frame_05.bf.Destroyable;
import lesson6.part_04.frame_05.bf.Drawable;

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
