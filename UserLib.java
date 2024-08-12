package LibraryManagementSystem;


import LibraryManagementSystem.userComparators.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLib implements Iterable <User>{
    ArrayList<User> m_users = new ArrayList<User> ();
    ArrayList <CompareUser> m_comparator = new ArrayList<> ();;

    public UserLib () {
    }
    public UserLib ( String fn ) {
        m_users = loadUsersFromTextFile ( fn ) ;
        m_comparator.add ( new CompareFirstName() );
        m_comparator.add ( new CompareLastName() );
        m_comparator.add ( new CompareId()  );
        m_comparator.add ( new CompareEmail()  );
    }

    public ArrayList<User> users ( ) {
        return m_users;
    }

    public void sort (String field, boolean descending ) {
        Comparator<User> comparator;

        switch (field) { // find which type we are looking at
            case "ID":
                comparator = new CompareId(descending);
                break;
            case "Last Name":
                comparator = new CompareLastName(descending);
                break;
            case "First Name":
                comparator = new CompareFirstName(descending);
                break;
            case "Email":
                comparator = new CompareEmail(descending);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        m_users.sort(comparator); // sort base on type

    }

    @Override
    public Iterator<User> iterator () {
        return m_users.iterator ();
    }

    public Iterator <User> iterator (Pattern pattern, String field) {
        // xxx your codes
        // xxx the iterator must iterate only the users whose the specfied
        // xxx field matches the regular expression pattern.

        ArrayList<User> ans = new ArrayList<>();

        for (User user : m_users) {

            String value = "";
            switch (field) { // find which type we are looking at
                case "First Name":
                    value = user.getFirstName();
                    break;
                case "Last Name":
                    value = user.getLastName();
                    break;
                case "Email":
                    value = user.getEmail();
                    break;
                case "ID":
                    value = String.valueOf(user.getId());
                    break;
                default:
                    value = user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getId();
                    break;
            }
            Matcher match = pattern.matcher(value); // checks if the value matches the pattern
            if(match.find()) { // if there was a match find will report true
                ans.add(user); // add that user to the list
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
            out.writeObject(m_users);
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
    public ArrayList <User> loadUsers( String filename ) {
        try {
            // Reading the users from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            m_users = (ArrayList<User>)in.readObject();

            System.out.println(m_users);

            in.close();
            file.close();

            int n = m_users.size();
            System.out.println("User dataBase is being loaded with " + n + " users.");
        } catch(Exception ex) {
            System.out.println(ex.getClass().getName() + " 2 is caught");
        }
        return m_users;
    }

    // load users from backend database file

    private User foo (Scanner fileInput, String temp ) {
        User newUser = new User();  // create a new user object
        Boolean b =   temp.equals ("active")   ;
        newUser.setActive(b); // set the first thing read in to firstName
        newUser.setFirstName( fileInput.nextLine() ); // set the first thing read in to firstName
        newUser.setLastName(fileInput.nextLine());  // files reads line by line, so do .nextLine
        newUser.setEmail(fileInput.nextLine());
        newUser.setPassword(fileInput.nextLine());
        newUser.setLibraryCardNum(fileInput.nextLine());
        newUser.setTypeOfUser(fileInput.nextLine());

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
        return newUser ;
    }

    public ArrayList<User> loadUsersFromTextFile ( String filename ) {
        try {
            File file = new File( filename );
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNextLine()) {
                String temp = fileInput.nextLine();
                if (temp.trim().length() > 0) {
                    User newUser = foo ( fileInput, temp );
                    m_users.add ( newUser );
                }
            }
            fileInput.close();
        } catch (IOException ex ) {
            System.out.println(ex.getMessage());
        }
        return m_users;
    }

    public void add(User newUser) {
        m_users.add(newUser);
    }

}
