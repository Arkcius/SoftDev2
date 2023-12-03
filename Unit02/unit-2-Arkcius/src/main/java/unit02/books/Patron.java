package unit02.books;

public class Patron{
    private String name;
    private Book book;

    public Patron(String name){
        this.name = name;
        this.book = null;
    }
    public String getName(){return this.name;}
    public Book getBook(){return this.book;}

    public void checkout(Book book){
        if(book.getAvalible()==true){
            if(this.book == null){
                this.book = book;
                book.setAvalible();
            }
            else{
                System.out.println("Patron Already has a Book checked out");
            }
        }
        else{
            System.out.println(book+" not Avaliable");
        }
    }
    public void returnBook(Book book){
        if(this.book != null){
            this.book.setAvalible();
            this.book = null;
        }
        else{
            System.out.println("No books to return");
        }
    }
    @Override
    public String toString(){
        return name+" Out Books: "+book;
    }
}
