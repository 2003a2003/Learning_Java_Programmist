package lesson3.part_2.frame_15;

public class RoundGlyphSecond extends Glyph{

    private int[] number = {0,1,2,3};
    //private int[] number = new int[14]{0,1,2,3};
    private String nameOfFigure = "Alex";

    @Override
    public void draw() {
        System.out.println("RoundGlyphSecond#draw() ");
        //System.out.println("Length: " + number.length);
        System.out.println("number[0]: " + number[0]);
        //System.out.println("The length of the name of the figure " + nameOfFigure.length());
    }
}
