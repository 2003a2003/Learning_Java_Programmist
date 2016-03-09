package lesson1.part_5.frame_7;

import java.util.Arrays;

public class Library {

    private Book[] book;
    private Book[] sortByWriter;
    private Book[] sortByTitle;
    private Book[] sortByGenre;
    private Genre genre;
    private int sizeArray = 46;
    private int tail;
    private int outIndex;

    //KONSTRUKTOR
    public Library() {
        book = new Book[sizeArray];
        addBookToLibrary(book);
        setTail(searchTail(book));
        outIndex = 0;
        updateOtherArray();
    }


    //SET
    private void setBook(Book[] book) {
        this.book = book;
    }

    private void setGenre(Genre genre) {
        this.genre = genre;
    }

    private void setTail(int tail) {
        this.tail = tail;
    }

    private void setSortByWriter(Book[] sortByWriter) {
        this.sortByWriter = sortByWriter;
    }

    private void setSortByTitle(Book[] sortByTitle) {
        this.sortByTitle = sortByTitle;
    }

    private void setSortByGenre(Book[] sortByGenre) {
        this.sortByGenre = sortByGenre;
    }

    private void setOutIndex(int outIndex) {
        this.outIndex = outIndex;
    }

    //GET
    private int getOutIndex() {
        return outIndex;
    }

    public int getTail() {
        return tail;
    }

    public Book[] getBook() {
        return book;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book[] getSortByWriter() {
        return sortByWriter;
    }

    public Book[] getSortByTitle() {
        return sortByTitle;
    }

    public Book[] getSortByGenre() {
        return sortByGenre;
    }

    public int getSizeArray() {
        return sizeArray;
    }

    //METODS
    public void printListBook(Book[] b) {
        int index = 1;
        for (Book book : b) {
            if (book != null) {
                System.out.println(index + ". Title: " + book.getTitle() + ", Autor: " + book.getWriter() +
                        ",  Genge: " + book.getGenre());
                index++;
            }
        }
        System.out.println("Total books: " + (index - 1));
    }

    private int searchTail(Book[] book) {
        int index = 0;
        if (book != null) {
            for (Book b : book) {
                if (b != null) {
                    index++;
                }
            }
        }
        return index;
    }

    private void addBookToLibrary(Book[] b) {
        b[0] = new Book("Harry Potter and the Philosopher's Stone", "Joanne Rowling", Genre.FANTASY);
        b[1] = new Book("Harry Potter and the Chamber of Secrets", "Joanne Rowling", Genre.FANTASY);
        b[2] = new Book("Harry Potter and the Prisoner of Azkaban", "Joanne Rowling", Genre.FANTASY);
        b[3] = new Book("Harry Potter and the Goblet of Fire ", "Joanne Rowling", Genre.FANTASY);
        b[4] = new Book("The Chronicles of Narnia. The Lion, the Witch and the Wardrobe", "Clive Staples Lewis", Genre.FANTASY);
        b[5] = new Book("The Chronicles of Narnia: Prince Caspian", "Clive Staples Lewis", Genre.FANTASY);
        b[6] = new Book("The Silver Chair", "Clive Staples Lewis", Genre.FANTASY);
        b[7] = new Book("Black Flags: The Rise of ISIS", "Joby Warrick", Genre.HISTORY);
        b[8] = new Book("The Silk Roads: A New History of the World", "Peter Frankopan", Genre.HISTORY);
        b[9] = new Book("Strange Gods: A Secular History of Conversion", "Susan Jacoby", Genre.HISTORY);
        b[10] = new Book("One Summer: America, 1927", "Bill Bryson", Genre.HISTORY);
        b[11] = new Book("Bridget Jones's Diary", "Helen Fielding", Genre.HUMOR);
        b[12] = new Book("The Hobbit", "J. R. R. Tolkien", Genre.FANTASY);
        b[13] = new Book("Charlie and the Chocolate Factory", "Roald Dahl", Genre.FAIRY_TALES);
        b[14] = new Book("The Graveyard Book", "Neil Gaiman", Genre.FAIRY_TALES);
        b[15] = new Book("Remember me?", "Sophie Kinsella", Genre.HUMOR);
        b[16] = new Book("he Wonderful Wizard of Oz", "Lyman Frank Baum", Genre.FAIRY_TALES);
        b[17] = new Book("Confessions of a Shopaholic", "Sophie Kinsella", Genre.HUMOR);
        b[18] = new Book("i", "g", Genre.FANTASY);
        b[19] = new Book("o", "r", Genre.FANTASY);
        b[20] = new Book("p", "m", Genre.FANTASY);
        b[21] = new Book("z", "m", Genre.FANTASY);
        b[22] = new Book("x", "l", Genre.ROMAN);
        b[23] = new Book("c", "l", Genre.ROMAN);
        b[24] = new Book("v", "l", Genre.FANTASY);
        b[25] = new Book("b", "l", Genre.FANTASY);
        b[26] = new Book("n", "w", Genre.FANTASY);
        b[27] = new Book("m", "w", Genre.FANTASY);
        b[28] = new Book("bb", "w", Genre.HISTORY);
        b[29] = new Book("qa", "q", Genre.FANTASY);
        b[30] = new Book("ws", "a", Genre.FANTASY);
        b[31] = new Book("ed", "z", Genre.HISTORY);
        b[32] = new Book("rf", "s", Genre.FANTASY);
        b[33] = new Book("tg", "x", Genre.HISTORY);
        b[34] = new Book("yh", "e", Genre.FANTASY);
        b[35] = new Book("uj", "d", Genre.ROMAN);
        b[36] = new Book("ik", "c", Genre.ROMAN);
        b[37] = new Book("ol", "r", Genre.ROMAN);
        b[38] = new Book("pl", "f", Genre.FANTASY);
        b[39] = new Book("az", "v", Genre.FANTASY);
        b[40] = new Book("sx", "t", Genre.FANTASY);
        b[41] = new Book("dc", "g", Genre.ROMAN);
        b[42] = new Book("fv", "b", Genre.ROMAN);
        b[43] = new Book("gb", "y", Genre.ROMAN);
        b[44] = new Book("hn", "h", Genre.HISTORY);
    }

    private void arraySortByWriter() {

        String[] array = new String[tail];
        array = transformByAutorString(book);

        Arrays.sort(array);
        Book[] rezult = new Book[book.length];

        int i = 0;
        while (i < tail-1) {
            for (int j = 0; j < tail; j++) {
                if (book[i] != null && array[i].equals(book[j].getWriter())) {
                    rezult[i] = book[j];
                    i++;
                }
            }
        }
        setSortByWriter(rezult);
    }

    private void arraySortByTitle() {
        String[] array = new String[tail];
        array = transformByTitleString(book);

        Arrays.sort(array);

        Book[] rezult = new Book[book.length];
        int i = 0;
        while (i < tail-1) {
            for (int j = 0; j < tail; j++) {
                if (book[i] != null && array[i].equals(book[j].getTitle())) {
                    rezult[i] = book[j];
                    i++;
                }
            }
        }
        setSortByTitle(rezult);
    }

    public void arraySortByGenre(Book[] bks) {

        int tail = searchTail(bks);

        Genre[] arr = Genre.values();
        String[] arrToStrong = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrToStrong[i] = arr[i].toString();
        }

        Arrays.sort(arrToStrong);

        Book[] rezult = new Book[bks.length];

        int i = 0;
        int k = 0;

        while (i < arr.length) {
            while (k < tail-1) {
                for (int j = 0; j < tail; j++) {
                    if (bks[j] != null && arrToStrong[i].equals(bks[j].getGenre().toString())) {
                        rezult[k] = bks[j];
                        k++;
                    }
                }
                i++;
            }
        }
        setSortByGenre(rezult);
    }

    private String[] transformByAutorString(Book[] bk) {
        String[] rez = new String[searchTail(bk)];
        for (int i = 0; i < searchTail(bk); i++) {
            rez[i] = bk[i].getWriter();
        }
        return rez;
    }

    private String[] transformByTitleString(Book[] bk) {
        String[] rez = new String[searchTail(bk)];
        for (int i = 0; i < searchTail(bk); i++) {
            rez[i] = bk[i].getTitle();
        }
        return rez;
    }

    public void searchByWriter(String writer) {
        if (writer == null || writer.length() < 3) {
            System.out.println("Enter the name of the author!!!!");

        } else {
            System.out.println(writer);
            int index = 1;
            boolean exit = false;
            for (Book book : getSortByWriter()) {
                if (book != null) {
                    if (book.getWriter().trim().equals(writer.trim())) {
                        printBook(book, index);
                        index++;
                        if (exit != true) {
                            exit = true;
                        }
                    } else if (exit == true) {
                        break;
                    }
                }
            }
        }
    }

    public void searchByTitle(String title) {
        if (title == null || title.length() < 3) {
            System.out.println("Enter the title to search!!!!");
        }else {
            System.out.println(title);
            int index = 1;
            boolean exit = false;
            for (Book bks : getSortByTitle()) {
                if (bks != null) {
                    if (bks.getTitle().trim().equals(title.trim())) {
                        printBook(bks, index);
                        index++;
                        if (exit != true) {
                            exit = true;
                        }
                    } else if (exit == true) {
                        break;
                    }
                }
            }
        }
    }

    public void searchByGenre(Genre genre) {
        if (genre == null ) {
            System.out.println("Enter the genre to search!!!!");
        }else {
            System.out.println(genre);
            int index = 1;
            boolean exit = false;
            Book[] array = getSortByGenre();
            for (int i = getOutIndex(); i < tail; i++) {

                if (array[i] != null && array[i].getGenre().equals(genre)) {
                    printBook(array[i], index);

                    if (index == 5) {
                        setOutIndex(++i);
                        break;
                    }

                    if (exit != true) {
                        exit = true;
                    }

                    index++;

                } else if (exit == true) {
                    setOutIndex(0);
                    break;
                }
            }
        }
    }

    public void printBook(Book bk, int index) {
        System.out.println(index + ". Autor: " + bk.getWriter() + ", Title: " + bk.getTitle() + ", Ganre: " + bk.getGenre());
    }

    public void addBookToDatabare(String writer, String title, Genre genre){
        if(tail >= book.length) {
            createNewBooksStorageAndCopeBase();
        }
        addBook(writer,title,genre);
        setTail(searchTail(book));
        updateOtherArray();
    }

    private void updateOtherArray(){
        sortByWriter = new Book[book.length];
        sortByTitle = new Book[book.length];
        sortByGenre = new Book[book.length];
        arraySortByWriter();
        arraySortByTitle();
        arraySortByGenre(book);

    }

    private void addBook(String writer, String title, Genre genre){
        book[tail] = new Book();
        book[tail].setWriter(writer);
        book[tail].setTitle(title);
        book[tail].setGenre(genre);
    }

    private void createNewBooksStorageAndCopeBase(){
        Book[] tempBook = book;
        book = createNewStorage();
        copyOldDateToNewBase(tempBook, book);
    }

    private void copyOldDateToNewBase(Book[] oldBase,Book[] newBase){
        System.arraycopy(oldBase,0,newBase,0, oldBase.length);
    }

    private Book[] createNewStorage(){
        return new Book[(int)(book.length*1.5)];
    }
}