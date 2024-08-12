package LibraryManagementSystem.bookComparators;
import LibraryManagementSystem.Book;
import LibraryManagementSystem.Library;

public class CompareISBN extends CompareBook {
    public CompareISBN() {
        super(Library.ISBN, false);
    }
    public CompareISBN(boolean reverse ) {
        super(Library.ISBN, reverse);
    }

    @Override
    public int compare(Book o1, Book o2) {
            if( m_reverse)
                return  Long.compare(o2.getISBN(),o1.getISBN());
            else {
                return  Long.compare(o1.getISBN(),o2.getISBN());
            }
    }

}
