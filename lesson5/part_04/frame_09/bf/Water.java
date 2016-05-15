package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {

	private  final static String NAME_IMAGE = "iWater.png";

	public Water(int x, int y) {
		super(x, y);
	//	color = new Color(0, 0, 194);
		try{
			img = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}
}
