package LibraryManagementSystem;

import java.io.Serializable;

public class Book  implements Comparable<Book>, Serializable {

    private String title;
    private String author;
    private Long ISBN;
    private boolean status;

    public Book() {

    }
    public Book(String title, String author, Long ISBN, boolean status ) {
        super();
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    @Override
    public String toString () {
        StringBuilder a = new StringBuilder();
        a.append(String.format ("%2d", getISBN() ) ) ;
        a.append(" - " ) ;
        a.append(getTitle() );
        a.append(" - " ) ;
        a.append(getAuthor()  ) ;
        return a.toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int compareTo(Book book) { return getAuthor().compareTo ( book.getAuthor() ); }

    @Override
    public boolean equals (Object u) { return this.compareTo ( (Book) u ) == 0 ;
    }
    @Override
    public int hashCode () { return getAuthor().hashCode();}
}
