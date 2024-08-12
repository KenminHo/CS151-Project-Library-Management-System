package LibraryManagementSystem;

import LibraryManagementSystem.Library;
import LibraryManagementSystem.User;

public class CompareFirstName extends CompareUser {

	public CompareFirstName() {
		super(Library.FIRST_NAME, false);
	}
	public CompareFirstName(boolean reverse ) {
		super(Library.FIRST_NAME, reverse );
	}

    @Override
    public int compare(User o1, User o2) {
		int result= o1.getFirstName().compareTo(o2.getFirstName());

		if (result == 0) {
			if( m_reverse)
				return  Integer.compare(o2.getId(),o1.getId());
			else {
				return  Integer.compare(o1.getId(),o2.getId());
			}
		}

		if (m_reverse) {
			return -result;
		}
		return result;
    }
};

