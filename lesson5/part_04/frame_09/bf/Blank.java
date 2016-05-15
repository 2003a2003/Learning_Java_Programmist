package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {

	private  final static String NAME_IMAGE = "iBlank.png";

	public Blank(int x, int y) {
		super(x, y);
//		color = new Color(180, 180, 180);
		try{
			img = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		int x = getX();
		int y = getY();

		g.drawImage(img, x, y, 65,65, new ImageObserver() {
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				return false;
			}
		});
	}
}
