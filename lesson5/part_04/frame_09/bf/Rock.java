package lesson5.part_04.frame_09.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {

	public Rock(int x, int y) {
		super(x, y);
		try{
			img = ImageIO.read(new File("iRock.png").getAbsoluteFile());
		}catch (IOException e){
			System.out.println("Can't find image Rock.");
		}
	}
}
