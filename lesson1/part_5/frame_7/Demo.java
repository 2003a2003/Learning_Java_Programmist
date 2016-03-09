package lesson1.part_5.frame_7;

/**
 * Created by otroshenko on 18.02.2016.
 */
public class Demo {
    public static void main(String[] args) throws Exception{

        Library lib = new Library();
        lib.printListBook(lib.getBook());
        //lib.printListBook(lib.getSortByWriter());
        printSeparator();
//        System.out.print("Search by Autor: ");
//        lib.searchByWriter("Joanne Rowling");
//        //lib.printListBook(lib.getSortByTitle());
//        printSeparator();
//        System.out.print("Search by Title: ");
//        lib.searchByTitle("The Hobbit");
//        //lib.printListBook(lib.getSortByGenre());
//        printSeparator();
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
//        printSeparator();
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
//        printSeparator();
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
//        printSeparator();
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
//        printSeparator();
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
//        printSeparator();
//        System.out.println("Tut po krugu poshli $)");
//        System.out.print("Search by Genre: ");
//        lib.searchByGenre(Genre.FANTASY);
        lib.addBookToDatabare("TomSoer", "Testet", Genre.FAIRY_TALES);
        lib.addBookToDatabare("TomSoer", "Testet2", Genre.FAIRY_TALES);
        lib.printListBook(lib.getBook());
        System.out.print("Search by Autor: ");
        lib.searchByWriter("TomSoer");
    }

    public static void printSeparator(){
        System.out.println("--------------------------------------------------------------------------");
    }
}