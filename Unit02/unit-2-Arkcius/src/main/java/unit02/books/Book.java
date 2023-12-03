package unit02.books;

public class Book{
    private String title;
    private String author;
    private boolean avalible;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.avalible = true;
    }
    public String getTitle(){return this.title;}
    public String getAuthor(){return this.author;}
    public boolean getAvalible(){return this.avalible;}
    public void setAvalible(){
        if(this.avalible == true){
        this.avalible = false;}
        else{
            this.avalible = true;
        }}
    @Override
    public String toString(){
        return title+" By "+author;
    }
}
