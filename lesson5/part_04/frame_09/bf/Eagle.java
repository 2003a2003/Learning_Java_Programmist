package lesson5.part_04.frame_09.bf.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Eagle extends SimpleBFObject {

	private final static String NAME_IMAGE = "iEagle.png";

	public Eagle(int x, int y) {
		super(x, y);
//		color = new Color(168, 168, 0);
		try{
			iEagle = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}
}
