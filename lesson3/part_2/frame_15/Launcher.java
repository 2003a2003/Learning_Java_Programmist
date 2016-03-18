package lesson3.part_2.frame_15;

public class Launcher {
    public static void main(String[] args) {
//        Glyph g = new RoundGlyph(25);
//        g.draw();

        try {
            new RoundGlyphSecond();
        }catch (NullPointerException e){
            System.out.println("NullPointerException - Stop run");
        }
    }
}
