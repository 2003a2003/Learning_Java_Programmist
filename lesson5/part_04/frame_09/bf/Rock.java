package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {

	private final static String NAME_IMAGE = "iRock.png";

	public Rock(int x, int y) {
		super(x, y);
		//color = new Color(136, 128, 143);
		try{
			img = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}

}
