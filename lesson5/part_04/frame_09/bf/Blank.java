package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {

	public Blank(int x, int y) {
		super(x, y);
		try{
			img = ImageIO.read(new File("iBlank.png").getAbsoluteFile());
		}catch (IOException e){
			System.out.println("Can't find image Blank.");
		}
	}
}
