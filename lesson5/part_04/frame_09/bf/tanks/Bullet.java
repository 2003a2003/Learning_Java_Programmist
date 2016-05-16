package lesson5.part_04.frame_09.bf.tanks;

import lesson5.part_04.frame_09.Direction;
import lesson5.part_04.frame_09.bf.Destroyable;
import lesson5.part_04.frame_09.bf.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bullet implements Drawable, Destroyable {

	private int speed = 5;
	
	private int x;
	private int y;
	private Direction direction;
	private AbstractTank tank;

	private final String B_UP = "bullet_up.png";
	private final String B_DOWN = "bullet_down.png";
	private final String B_LEFT = "bullet_left.png";
	private final String B_RIGTH = "bullet_rigth.png";

	private String NAME_IMAGE;
	private Image img;

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
		setImages();

		if (!destroyed) {
			if(img != null){
				g.drawImage(img, getX(), getY(), null);
			}else {
				g.setColor(new Color(234, 246, 76));
				g.fillRect(this.x, this.y, 14, 14);
			}
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

	private void setImages() {

		if (this.getDirection() == Direction.UP) {
			NAME_IMAGE = B_UP;
		} else if (this.getDirection() == Direction.DOWN) {
			NAME_IMAGE = B_DOWN;
		} else if (this.getDirection() == Direction.LEFT) {
			NAME_IMAGE = B_LEFT;
		} else {
			NAME_IMAGE = B_RIGTH;
		}

		try {
			img = ImageIO.read(new File(NAME_IMAGE));
		} catch (IOException e) {
			System.err.println("Can't find image: " + NAME_IMAGE);
		}
	}
}
