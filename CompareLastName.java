package LibraryManagementSystem;
import LibraryManagementSystem.Library;
import LibraryManagementSystem.User;


public class CompareLastName extends CompareUser {
	// xxx your code

	public CompareLastName() {
		super( Library.LAST_NAME, false );
	}
	public CompareLastName(boolean reverse ) {
		super( Library.LAST_NAME, reverse );
	}

    @Override
    public int compare(User o1, User o2) {
		int result= o1.getLastName().compareTo(o2.getLastName());

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

