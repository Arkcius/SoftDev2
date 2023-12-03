package unit02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unit02.books.Book;
import unit02.books.Patron;

public class BooksANDPatronTest{
    Book novella = new Book("Novella", "Me");
    Book novel = new Book("Novel", "Also ne");
    Patron fred = new Patron("Fred");
    Patron bob = new Patron("bob");
    @Test
    public void chechkout(){
        Book expected = novella;
        fred.checkout(novella);
        Book actual = fred.getBook();
        assertEquals(expected, actual);
    }
    @Test
    public void returnBook(){
        Book expected = null;
        fred.checkout(novella);
        fred.returnBook(novella);
        Book actual = fred.getBook();
        assertEquals(expected, actual);
    }
    @Test
    public void alreadyHaveBook(){
        boolean expected = novel.getAvalible();
        fred.checkout(novella);
        fred.checkout(novel);
        boolean actual = novel.getAvalible();
        assertEquals(expected, actual);
    }
    @Test
    public void alreadyHaveBook2(){
        fred.checkout(novella);
        Book expected = fred.getBook();
        fred.checkout(novel);
        Book actual = fred.getBook();
        assertEquals(expected, actual);
    }
    @Test
    public void bookUnavaliable(){
        Book expected = null;
        novella.setAvalible();
        fred.checkout(novella);
        Book actual = fred.getBook();
        assertEquals(expected, actual);
    }
}
