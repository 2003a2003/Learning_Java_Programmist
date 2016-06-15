package lesson6.part_05.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {

	public Blank(int x, int y) {
		super(x, y);
		try{
			img = ImageIO.read(new File("iBlank04.jpg").getAbsoluteFile());
		}catch (IOException e){
			System.out.println("Can't find image Blank.");
		}
	}
}
