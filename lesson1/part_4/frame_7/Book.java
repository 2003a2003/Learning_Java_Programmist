package lesson1.part_4.frame_7;

public class Book {

    private String title;
    private Genre genge;
    private String writer;

    public Book(){
        this("No information","No information",null);
    }

    public Book(String title, String writer, Genre genge){
        this.title = title;
        this.writer = writer;
        this.genge = genge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenge() {
        return genge;
    }

    public void setGenge(Genre genge) {
        this.genge = genge;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}