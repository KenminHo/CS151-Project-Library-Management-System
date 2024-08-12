package LibraryManagementSystem;

import LibraryManagementSystem.Library;
import LibraryManagementSystem.User;

public class CompareEmail extends CompareUser {

	public CompareEmail() {
		super(Library.EMAIL, false );
	}
	public CompareEmail(boolean reverse ) {
		super(Library.EMAIL, reverse );
	}

    @Override
    public int compare(User o1, User o2) {

		if( m_reverse)
			return  o2.getEmail().compareTo(o1.getEmail());
		else {
			return  o1.getEmail().compareTo(o2.getEmail());
		}

    }
};

