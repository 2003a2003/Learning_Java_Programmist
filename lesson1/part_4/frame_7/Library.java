package lesson1.part_4.frame_7;

public class Library {

    private Book[] book;
    private Genre g;
    private int tail;


    public Library() {
        book = new Book[100];
        addBookToLibrary(book);
    }

    private void setBook(Book[] book) {
        this.book = book;
    }

    private void addBook(int index, String title, String autor, Genre genre) {
        book[index] = new Book(title, autor, genre);
    }

    public void printListBook(Book[] b) {
        int index = 1;
        if (b != null) {
            for (Book book : b) {
                if (book != null) {
                    System.out.println(index + ". Title: " + book.getTitle() + ", Autor: " + book.getWriter() +
                            ",  Genge: " + book.getGenge());
                    index++;
                }
            }
            System.out.println("Total books: " + (index-1));
        }else {
            System.out.println("You don't have Library!!!!");
        }
    }

    public int getTail() {
        return tail;
    }

    public void searchTail() {
        int index = 0;
        if (book != null) {
            for (Book b : book) {
                if (b != null) {
                    index++;
                }
            }
        }
        System.out.println("Coll elementow v massive: " + index);
    }

    private void addBookToLibrary(Book[] b){

        b[0] = new Book("a","a", Genre.FANTASY);
        b[1] = new Book("b","a", Genre.FANTASY);
        b[2] = new Book("c","a", Genre.FANTASY);
        b[3] = new Book("d","a", Genre.FANTASY);
        b[4] = new Book("e","a", Genre.CONPUTERS);
        b[5] = new Book("f","a", Genre.CONPUTERS);
        b[6] = new Book("g","a", Genre.HISTORY);
        b[7] = new Book("h","a", Genre.HISTORY);
        b[8] = new Book("j","a", Genre.HISTORY);
        b[9] = new Book("k","a", Genre.FOOD);
        b[10] = new Book("l","a", Genre.ROMAN);
        b[11] = new Book("q","b", Genre.ROMAN);
        b[12] = new Book("w","b", Genre.ROMAN);
        b[13] = new Book("e","b", Genre.FANTASY);
        b[14] = new Book("r","c", Genre.ROMAN);
        b[15] = new Book("t","c", Genre.ROMAN);
        b[16] = new Book("y","c", Genre.ROMAN);
        b[17] = new Book("u","c", Genre.FANTASY);
        b[18] = new Book("i","g", Genre.FANTASY);
        b[19] = new Book("o","r", Genre.FANTASY);
        b[20] = new Book("p","m", Genre.FANTASY);
        b[21] = new Book("z","m", Genre.FANTASY);
        b[22] = new Book("x","l", Genre.ROMAN);
        b[23] = new Book("c","l", Genre.ROMAN);
        b[24] = new Book("v","l", Genre.FANTASY);
        b[25] = new Book("b","l", Genre.FANTASY);
        b[26] = new Book("n","w", Genre.FANTASY);
        b[27] = new Book("m","w", Genre.FANTASY);
        b[28] = new Book("bb","w", Genre.HISTORY);
        b[29] = new Book("qa","q", Genre.FANTASY);
        b[30] = new Book("ws","a", Genre.FANTASY);
        b[31] = new Book("ed","z", Genre.HISTORY);
        b[32] = new Book("rf","s", Genre.FANTASY);
        b[33] = new Book("tg","x", Genre.HISTORY);
        b[34] = new Book("yh","e", Genre.FANTASY);
        b[35] = new Book("uj","d", Genre.ROMAN);
        b[36] = new Book("ik","c", Genre.ROMAN);
        b[37] = new Book("ol","r", Genre.ROMAN);
        b[38] = new Book("pl","f", Genre.FANTASY);
        b[39] = new Book("az","v", Genre.FANTASY);
        b[40] = new Book("sx","t", Genre.FANTASY);
        b[41] = new Book("dc","g", Genre.ROMAN);
        b[42] = new Book("fv","b", Genre.ROMAN);
        b[43] = new Book("gb","y", Genre.ROMAN);
        b[44] = new Book("hn","h", Genre.HISTORY);
    }

    public Book[] getBook() {
        return book;
    }

    public Genre getG() {
        return g;
    }

    private void setG(Genre g) {
        this.g = g;
    }

    private void setTail(int tail) {
        this.tail = tail;
    }

    public void sortArray(Book[] b){
        String[] str = new String[100];

        for (int i = 0; i < b.length; i++){
            if(b[i] != null) {
                System.out.println(b[i]);
            }
        }


    }







}
