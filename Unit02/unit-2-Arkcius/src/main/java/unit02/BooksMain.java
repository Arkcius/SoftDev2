package unit02;
import unit02.books.Book;
import unit02.books.Patron;
public class BooksMain{
    public static void main(String[] args){
        Book novella = new Book("Novella", "Me");
        Book novel = new Book("Novel", "Also ne");
        Patron fred = new Patron("Fred");
        Patron bob = new Patron("bob");
        fred.checkout(novella);
        System.out.println(fred);
        fred.checkout(novel);
        System.out.println(fred);
        bob.checkout(novella);
        System.out.println(bob);
        fred.returnBook(novella);
        System.out.println(fred);
        fred.checkout(novel);
        System.out.println(fred);
        bob.checkout(novella);
        System.out.println(bob);

    }
}
