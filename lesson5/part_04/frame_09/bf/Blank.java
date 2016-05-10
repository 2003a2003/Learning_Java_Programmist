package lesson5.part_04.frame_09.bf.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {

//	private  final static String NAME_IMAGE = "iBlank.png";

	public Blank(int x, int y) {
		super(x, y);
		color = new Color(180, 180, 180);
//		try{
//			iBlank = ImageIO.read(new File(NAME_IMAGE));
//		}catch (IOException e){
//			System.out.println("Can't find image: " + NAME_IMAGE);
//		}
	}
}
