package lesson1.part_5.frame_7;

public class Book {

    private String title;
    private Genre genre;
    private String writer;

    public Book(){
        this("No information","No information",null);
    }

    public Book(String title, String writer, Genre genre){
        this.title = title;
        this.writer = writer;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}