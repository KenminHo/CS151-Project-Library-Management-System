package LibraryManagementSystem.userComparators;
import LibraryManagementSystem.Library;
import LibraryManagementSystem.User;


public class CompareId extends CompareUser {

    public CompareId() {
		super(Library.ID, false);
    }
    public CompareId(boolean reverse ) {
		super(Library.ID, reverse);
    }

    @Override
    public int compare(User o1, User o2) {
        if( m_reverse)
            return  Integer.compare(o2.getId(),o1.getId());
        else {
            return  Integer.compare(o1.getId(),o2.getId());
        }
    }
};

