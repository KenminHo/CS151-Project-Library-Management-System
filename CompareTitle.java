package LibraryManagementSystem;
import LibraryManagementSystem.Book;
import LibraryManagementSystem.Library;

public class CompareTitle extends CompareBook{
    public CompareTitle() {
        super(Library.TITLE, false);
    }
    public CompareTitle(boolean reverse ) {
        super(Library.TITLE, reverse );
    }

    @Override
    public int compare(Book o1, Book o2) {
        int result= o1.getTitle().compareTo(o2.getTitle());

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
