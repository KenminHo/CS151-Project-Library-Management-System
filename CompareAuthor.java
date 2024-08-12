package LibraryManagementSystem;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.Library;

public class CompareAuthor extends CompareBook {

    public CompareAuthor() {
        super(Library.AUTHOR, false);
    }
    public CompareAuthor(boolean reverse ) {
        super(Library.AUTHOR, reverse );
    }

    @Override
    public int compare(Book o1, Book o2) {
        int result= o1.getAuthor().compareTo(o2.getAuthor());

        if (result == 0) {
            if( m_reverse)
                return  Long.compare(o2.getISBN(),o1.getISBN());
            else {
                return  Long.compare(o1.getISBN(),o2.getISBN());
            }
        }

        if (m_reverse) {
            return -result;
        }
        return result;
    }
}
