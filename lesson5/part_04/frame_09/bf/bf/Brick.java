package lesson5.part_04.frame_09.bf.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.*;


public class Brick extends SimpleBFObject {

	private  final static String NAME_IMAGE = "iBrick.png";

	public Brick(int x, int y) {
		super(x, y);
		//color = new Color(94, 0, 12);
		try{
			iBrick = ImageIO.read(new File(NAME_IMAGE));
		}catch (IOException e){
			System.out.println("Can't find image: " + NAME_IMAGE);
		}
	}
}
