package lesson5.part_05.frame_05.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {

	public Rock(int x, int y) {
		super(x, y);
		try{
			img = ImageIO.read(new File("iRock.jpg").getAbsoluteFile());
		}catch (IOException e){
			System.out.println("Can't find image Rock.");
		}
	}
}
