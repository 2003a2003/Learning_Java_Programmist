package lesson5.part_04.frame_09.bf.bf;

import java.awt.*;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;
	
	protected Color color;

	private boolean isDestroyed = false;
	protected Image iBrick;
	protected Image iBlank;
	protected Image iEagle;
	protected Image iWater;
	protected Image iRock;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!isDestroyed) {
			g.setColor(this.color);
			g.fillRect(this.getX(), this.getY(), 64, 64);

			g.drawImage(iBrick, x, y, new ImageObserver() {

				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});

			g.drawImage(iEagle, x, y, new ImageObserver() {

				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});

			g.drawImage(iWater, x, y, new ImageObserver() {

				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});

			g.drawImage(iRock, x, y, new ImageObserver() {

				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});


//			g.drawImage(iBlank, x, y, new ImageObserver() {
//
//				@Override
//				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//					return false;
//				}
//			});
		}
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
