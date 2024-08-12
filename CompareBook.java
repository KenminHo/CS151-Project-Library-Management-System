package LibraryManagementSystem;

import LibraryManagementSystem.Book;
import LibraryManagementSystem.Library;


import java.util.Comparator;

public abstract class CompareBook implements Comparator<Book> {

    boolean m_reverse ;
    Library m_field ;

    public CompareBook(Library x, boolean reverse ) {
        super();
        m_reverse = reverse ;
        m_field = x;
    }


    String getFieldName () {
        return m_field.toString ();
    }

    @Override
    public abstract int compare(Book o1, Book o2) ;

    @Override
    public String toString () {
        String s = this.getClass().getName();
        if (m_reverse ) s += " (reverse)" ;
        return s ;
    }

};

