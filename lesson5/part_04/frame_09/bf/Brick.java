package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Brick extends SimpleBFObject {

	private  final static String NAME_IMAGE = "iBrick.png";

	public Brick(int x, int y) {
		super(x, y);
		//color = new Color(94, 0, 12);
		try{
			img = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}
}
