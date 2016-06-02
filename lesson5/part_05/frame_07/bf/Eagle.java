package lesson5.part_05.frame_07.bf;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Eagle extends SimpleBFObject {

	public Eagle(int x, int y) {
		super(x, y);
		try{
			img = ImageIO.read(new File("iEagle.jpg").getAbsoluteFile());
		}catch (IOException e){
			System.out.println("Can't find image Eagle.");
		}
	}
}