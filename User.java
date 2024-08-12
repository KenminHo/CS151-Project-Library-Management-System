package LibraryManagementSystem;

import java.io.*;

public class User implements Comparable<User>, Serializable{

    private String firstName;
    private String lastName;
    private String email;
    private int    m_id;
    private String password;
    static  int    m_count = 0 ;
    private String m_libraryCardNum;
    private boolean m_isActive = true;

    private String typeOfUser;

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    @Override
    public String toString () {
        StringBuilder a = new StringBuilder();
        a.append(String.format ("%2d", getId() ) ) ;
        a.append(" - " ) ;
        a.append(getFullName() );
        a.append(" - " ) ;
        a.append(getEmail()  ) ;
        return a.toString();
    }

    public User() {
        m_id = m_count ;
        m_count ++;
    }

    public User(String firstName, String lastName, String email ) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        m_id = m_count ;
        m_count ++;
    }

    public int getId() { return m_id; }

    public String getFullName() { return lastName + ", " + firstName; }

    // Getters and setters
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email; }

    public void setPassword(String passwd) { this.password = passwd; }

    public void setActive (boolean b) { m_isActive  = b ;}

    public void setLibraryCardNum(String num) { this.m_libraryCardNum = num;}

    public String getLibraryCardNum() { return m_libraryCardNum;}

    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(User user) { return getFullName().compareTo ( user.getFullName() ); }

    @Override
    public boolean equals (Object u) { return this.compareTo ( (User) u ) == 0 ;
    }
    @Override
    public int hashCode () { return getFullName().hashCode();}



}
