package LibraryManagementSystem;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookLib implements Iterable <Book>{
    ArrayList<Book> m_books = new ArrayList<Book> ();
    ArrayList <CompareBook> m_comparator = new ArrayList<> ();;

    public BookLib () {
    }
    public BookLib ( String fn ) {
        m_books = loadBooksFromTextFile ( fn ) ;
        m_comparator.add ( new CompareAuthor() );
        m_comparator.add ( new CompareTitle() );
        m_comparator.add ( new CompareISBN() );
    }

    public ArrayList<Book> books ( ) {
        return m_books;
    }

    public void sort (String field, boolean descending ) {
        Comparator<Book> comparator;

        switch (field) { // find which type we are looking at
            case "Author":
                comparator = new CompareAuthor(descending);
                break;
            case "Title":
                comparator = new CompareTitle(descending);
                break;
            case "ISBN":
                comparator = new CompareISBN(descending);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        m_books.sort(comparator); // sort base on type

    }

    @Override
    public Iterator<Book> iterator () {
        return m_books.iterator ();
    }

    public Iterator <Book> iterator (Pattern pattern, String field) {
        // xxx your codes
        // xxx the iterator must iterate only the users whose the specfied
        // xxx field matches the regular expression pattern.

        ArrayList<Book> ans = new ArrayList<>();

        for (Book book : m_books) {

            String value = "";
            switch (field) { // find which type we are looking at
                case "Author":
                    value = book.getAuthor();
                    break;
                case "Title":
                    value = book.getTitle();
                    break;
                case "ISBN":
                    value = String.valueOf(book.getISBN());
                    break;
                default:
                    value = book.getAuthor() + " " + book.getTitle() + " " + book.getISBN();
                    break;
            }
            Matcher match = pattern.matcher(value); // checks if the value matches the pattern
            if(match.find()) { // if there was a match find will report true
                ans.add(book); // add that user to the list
            }

        }
        return ans.iterator() ; // return list
    }

    public void saveUsers (   ArrayList <User> users, String filename )
    {
        try
        {
            //Saving of users in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of users
            out.writeObject(m_books);
            // System.out.println (m_users);

            out.close();
            file.close();

            System.out.println("Users database has been updated!!!");

        }
        catch(IOException ex)
        {
            System.out.println( ex.getClass().getName() + " 1 is caught");
        }
    }
    public ArrayList <Book> loadBooks( String filename ) {
        try {
            // Reading the users from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            m_books = (ArrayList<Book>)in.readObject();

            System.out.println(m_books);

            in.close();
            file.close();

            int n = m_books.size();
            System.out.println("User dataBase is being loaded with " + n + " users.");
        } catch(Exception ex) {
            System.out.println(ex.getClass().getName() + " 2 is caught");
        }
        return m_books;
    }

    // load users from backend database file

    private Book foo (Scanner fileInput, String temp ) {
        Book newBook = new Book();  // create a new user object
        Boolean b =   temp.equals ("available")   ;
        newBook.setStatus(b); // set the first thing read in to firstName
        newBook.setAuthor( fileInput.nextLine() ); // set the first thing read in to firstName
        newBook.setTitle(fileInput.nextLine());  // files reads line by line, so do .nextLine

        newBook.setISBN(Long.parseLong(fileInput.nextLine()));

        // if there is next line, it is checkout book isbn
        while (fileInput.hasNextLine()) {
            try {
                String tempLine = fileInput.nextLine(); // first thing we read from txt
                if (tempLine.trim().length() == 0) {   // break when no more lines to read
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        // System.out.println ( newUser );
        return newBook ;
    }

    public ArrayList<Book> loadBooksFromTextFile ( String filename ) {
        try {
            File file = new File( filename );
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String temp = fileInput.nextLine();
                if (temp.trim().length() > 0) {
                    Book newBook = foo ( fileInput, temp );
                    m_books.add ( newBook );
                }
            }
            fileInput.close();
        } catch (IOException ex ) {
            System.out.println(ex.getMessage());
        }
        return m_books;
    }
}
