package LibraryManagementSystem;

import java.util.ArrayList;

public enum Library {
	FIRST_NAME ("First Name" ),
	LAST_NAME ("Last Name" ),
	EMAIL ("Email" ),
	ID ("ID" ),
	AUTHOR ("Author"),
	TITLE ("Title" ),
	ISBN ("ISBN");


	private ArrayList <Book>  m_books = null;
	private ArrayList <User>  m_users = null;

	String m_thing ;
	Library(String s) {
		m_thing = s ;
	}



	@Override
	public String toString () {
		return m_thing ;
	}
	private Library() { // must be private
		m_users = new ArrayList <User> () ;
    	//m_libraryCardMap = new HashMap<>();
	}



}



