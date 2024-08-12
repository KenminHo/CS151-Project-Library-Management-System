package LibraryManagementSystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

public class Start implements ActionListener {

    JFrame n; JFrame f; JFrame i; JFrame p; JFrame j;

    JTextField txtSearch   = new JTextField("search");


    JPanel books; JPanel users; JPanel bar;
    JButton sign; JButton log; JButton exit; JButton submit; JButton login1;
    JTextArea first; JTextArea last; JTextArea email; JTextArea pass;
    JTextField firstInput; JTextField lastInput; JTextField emailInput; JTextField passInput;

    JComboBox sortBy; JComboBox sortAscend; JComboBox sortType;

    JButton sort; JButton Search;

    JComboBox<String> userBox = new JComboBox<>();

    static String firstName; static String lastName; static String emailName; static String password; static String cardNumber; static String User;

    UserLib m_libraryUsers = new UserLib ( "C:\\Users\\Frank Huawei\\IdeaProjects\\LibProject\\src\\Users.txt" );

    BookLib m_libraryBooks = new BookLib("C:\\Users\\Frank Huawei\\IdeaProjects\\LibProject\\src\\Books.txt");
    Start(){
        f=new JFrame("Library Login Page");

        JTextField d = new JTextField("WELCOME!!!");
        JTextField e = new JTextField("Not a user? Click here to sign up:");


        sign =new JButton("sign up");
        log =new JButton("login");
        exit =new JButton("exit");

        sign.setBounds(40,80,80, 40);
        log.setBounds(160,80,80, 40);
        exit.setBounds(100,220,80, 40);
        d.setBounds(90,30,100, 20);
        e.setBounds(40,160,200, 40);

        sign.addActionListener(this);
        log.addActionListener(this);
        exit.addActionListener(this);

        f.getContentPane().setBackground(Color.YELLOW);
        f.add(sign);
        f.add(log);
        f.add(exit);
        f.add(d);
        f.add(e);

        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void Sign() {
        n = new JFrame("Signup");
        first = new JTextArea("First Name:");
        last = new JTextArea("Last Name:");
        email = new JTextArea("Email: ");
        pass = new JTextArea("Password: ");

        submit =new JButton("submit");

        firstInput = new JTextField();
        lastInput = new JTextField();
        emailInput = new JTextField();
        passInput = new JTextField();

        String[] box = {"User", "Liberian"};
        userBox = new JComboBox<>(box);
        userBox.setSelectedIndex(0);



        first.setBounds(100,00,100, 20);
        last.setBounds(100,60,100, 20);
        email.setBounds(100,120,100, 20);
        pass.setBounds(100,180,100, 20);

        userBox.setBounds(100, 240, 100, 20);
        submit.setBounds(100,240,100, 20);


        firstInput.setBounds(100,20,100, 20);
        lastInput.setBounds(100,80,100, 20);
        emailInput.setBounds(100,140,100, 20);
        passInput.setBounds(100,200,100, 20);

        submit.addActionListener(this);


        first.setEditable(false);
        last.setEditable(false);
        email.setEditable(false);
        pass.setEditable(false);

        n.add(first);
        n.add(last);
        n.add(email);
        n.add(pass);

        n.add(firstInput);
        n.add(lastInput);
        n.add(emailInput);
        n.add(passInput);

        n.add(userBox);

        n.add(submit);

        n.setSize(300,400);
        n.setLayout(null);
        n.setVisible(true);
        f.setVisible(false);
        n.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                n.dispose();

                f.setVisible(true);
            }
        });
    }

    void Login() {
        i = new JFrame("Login");
        login1 =new JButton("login");


        first = new JTextArea("Username:");
        last = new JTextArea("Password:");

        firstInput = new JTextField();
        lastInput = new JTextField();

        firstInput.setBounds(100,20,100, 20);
        lastInput.setBounds(100,100,100, 20);

        login1.setBounds(100,180,100, 20);


        first.setBounds(100,00,100, 20);
        last.setBounds(100,80,100, 20);

        first.setEditable(false);
        last.setEditable(false);

        login1.addActionListener(this);

        i.add(first);
        i.add(last);
        i.add(firstInput);
        i.add(lastInput);
        i.add(login1);


        i.setSize(300,400);
        i.setLayout(null);
        i.setVisible(true);
        f.setVisible(false);
        i.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                i.dispose();
                f.setVisible(true);
            }
        });
    }
    public JPanel searchBar( ) {
        final JLabel lblSearch  = new  JLabel( "Search By" );
        String[] criteria = { "ID", "Last Name", "First Name", "Email" };
        sortBy = new  JComboBox( criteria );

        String[] criteria2 = { "All Fields", "Last Name", "First Name", "ID", "Email" };
        sortType = new  JComboBox( criteria2 );

        String[] criteria3 = { "Ascending", "Descending" };
        sortAscend = new  JComboBox( criteria3);

        JPanel p = new JPanel() ;
        BoxLayout layout = new BoxLayout(p, BoxLayout.X_AXIS);
        p.setLayout(layout);
        p.add(txtSearch);
        p.add(sortBy);
        p.add(sortType);
        p.add(sortAscend);

        Search = new JButton("Search");
        sort = new JButton("Sort");

        p.add(Search);
        p.add(sort);

        sort.addActionListener(this);
        Search.addActionListener(this);

        p.setBounds (50,450,500, 30);
        p.setBackground(Color.green);

        return p;
    }


    void userProfile() {


        p = new JFrame("User Profile");
        JPanel search = searchBar();




        users = new JPanel();
        users.setLayout(new BoxLayout(users, BoxLayout.Y_AXIS)); // Vertical layout for the labels
        users.setPreferredSize(new Dimension(400, 200));

        books = new JPanel();
        books.setPreferredSize(new Dimension(400, 200));

        // Add user details to left panel
        for (User u : m_libraryUsers) {
            JLabel label = new JLabel(u.toString());
            users.add(label);
        }

        for (Book i : m_libraryBooks) {
            JLabel label = new JLabel(i.toString());
            books.add(label);
        }
        JScrollPane scrollPane = new JScrollPane(users);
        JScrollPane scrollPane2 = new JScrollPane(books);

       // p.setLayout(new BorderLayout());

        p.add(scrollPane, BorderLayout.WEST);
        p.add(scrollPane2, BorderLayout.EAST);
        p.add(search, BorderLayout.SOUTH);


        p.setSize(1000, 600);
        p.setVisible(true);
        i.setVisible(false);


        j = new JFrame("Profile");

        JTextField d = new JTextField("WELCOME!");

        first = new JTextArea("First Name: " + firstName);
        last = new JTextArea("Last Name: " + lastName);
        email = new JTextArea("Email: " + emailName);
        pass = new JTextArea("Password: " + password);

        first.setBounds(0,00,200, 20);
        last.setBounds(0,20,200, 20);
        email.setBounds(0,40,200, 20);
        pass.setBounds(0,60,200, 20);

        first.setEditable(false);
        last.setEditable(false);
        email.setEditable(false);
        pass.setEditable(false);

        j.add(first);
        j.add(last);
        j.add(email);
        j.add(pass);

        j.setSize(100,100);
        j.setLayout(null);
        j.setVisible(true);
        i.setVisible(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                p.dispose();
                f.setVisible(true);
            }
        });
    }

    void librianProfile() {
        p = new JFrame("librian Profile");
        JPanel search = searchBar();

        users = new JPanel();
        users.setLayout(new BoxLayout(users, BoxLayout.Y_AXIS)); // Vertical layout for the labels
        users.setPreferredSize(new Dimension(400, 200));

        books = new JPanel();
        books.setPreferredSize(new Dimension(400, 200));

        // Add user details to left panel
        for (User u : m_libraryUsers) {
            JLabel label = new JLabel(u.toString());
            users.add(label);
        }

        for (Book i : m_libraryBooks) {
            JLabel label = new JLabel(i.toString());
            books.add(label);
        }
        JScrollPane scrollPane = new JScrollPane(users);
        JScrollPane scrollPane2 = new JScrollPane(books);

        // p.setLayout(new BorderLayout());

        p.add(scrollPane, BorderLayout.WEST);
        p.add(scrollPane2, BorderLayout.EAST);
        p.add(search, BorderLayout.SOUTH);


        p.setSize(1000, 600);
        p.setVisible(true);
        i.setVisible(false);


        j = new JFrame("Profile");

        JTextField d = new JTextField("WELCOME!");

        first = new JTextArea("First Name: " + firstName);
        last = new JTextArea("Last Name: " + lastName);
        email = new JTextArea("Email: " + emailName);
        pass = new JTextArea("Password: " + password);

        first.setBounds(0,00,200, 20);
        last.setBounds(0,20,200, 20);
        email.setBounds(0,40,200, 20);
        pass.setBounds(0,60,200, 20);

        first.setEditable(false);
        last.setEditable(false);
        email.setEditable(false);
        pass.setEditable(false);

        j.add(first);
        j.add(last);
        j.add(email);
        j.add(pass);

        j.setSize(100,100);
        j.setLayout(null);
        j.setVisible(true);
        i.setVisible(false);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                p.dispose();
                f.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sign) {
            Sign();
        }
        else if(e.getSource() == log) {
            Login();
        }
        else if(e.getSource() == login1) {
            try {
                String test = firstInput.getText();
                String test2 = lastInput.getText();



                checkUser(test, test2, m_libraryUsers, m_libraryBooks);



                JOptionPane.showMessageDialog(i, "Login Successful! Welcome, " + firstName + " " + lastName  , "Success", JOptionPane.INFORMATION_MESSAGE);
                i.dispose();  // Close the signup frame
                if(User.equals("User")) {
                    userProfile();
                } else if (User.equals("Librian")) {
                    librianProfile();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(i, ex.getMessage(), "Login failed", JOptionPane.ERROR_MESSAGE);

            }
        }
        else if(e.getSource() == submit){

            firstName = firstInput.getText();
            lastName = lastInput.getText();
            emailName = emailInput.getText();
            password = passInput.getText();

            try {
                validatePassword(password);
                Random random = new Random();
                int five = random.nextInt(10000,99999);

                cardNumber = String.valueOf(five);

                JOptionPane.showMessageDialog(n, "Signup Successfully! Your username/card number is: " + cardNumber  , "Success", JOptionPane.INFORMATION_MESSAGE);
                n.dispose();  // Close the signup frame

                User newUser = new User();  // create a new user object

                newUser.setActive(true); // set the first thing read in to firstName
                newUser.setFirstName(firstName); // set the first thing read in to firstName
                newUser.setLastName(lastName);  // files reads line by line, so do .nextLine
                newUser.setEmail(emailName);
                newUser.setPassword(password);
                newUser.setLibraryCardNum(cardNumber);
                newUser.setTypeOfUser(User);

                m_libraryUsers.add(newUser);
                f.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(n, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }

        }
        else if (e.getSource() == sort ) {  //
            String type = (String) sortBy.getSelectedItem();
            boolean descending = "Descending".equals(sortAscend.getSelectedItem());
            m_libraryUsers.sort(type, descending);
            users.removeAll(); // clear all current names/lists
            for (User u : m_libraryUsers) {
                JLabel label = new JLabel(u.toString());
                users.add(label); // add them back in sorted order
            }
            // xxx your code
            users.updateUI();
        }
        else if (e.getSource() == Search ) {  //
                // xxx Do not modify any codes below
                // xxx using JOptionPane.showMessageDialog

                String regex = txtSearch.getText () ;
                if ( regex.isEmpty() ) {
                    JOptionPane.showMessageDialog(this.searchBar(), "Search cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                String cri = (String) sortType.getSelectedItem();
                Pattern pattern = null;
                try {
                    pattern = Pattern.compile(regex );
                } catch (Exception ex ) {
                    // xxx your code
                    // xxx display error messages for "invalid" regular expression.
                    // xxx using JOptionPane.showMessageDialog
                    JOptionPane.showMessageDialog(this.searchBar(), "Invalid expression", "Error",JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                // xxx you must implement the libraryUsers.iterator() correctly
                Iterator<User> itr = m_libraryUsers.iterator ( pattern, cri );
                users.removeAll ();
                while (itr.hasNext () ) {
                    User u = itr.next ();
                    JLabel label = new JLabel(u.toString() );
                    users.add(label);
                }

                users.updateUI();
        }
        else if(e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void checkUser(String login, String pass, UserLib m_libraryUsers,  BookLib m_libraryBooks) throws Exception {
        Boolean loginCheck = false; Boolean passCheck = false;
        User save = null;
        for(User user : m_libraryUsers.m_users)
        {

            if(user.getLibraryCardNum().equals(login)){
                loginCheck = true;
                save = user;
            }
        }

            if(save != null && save.getPassword().equals(pass)){
                passCheck = true;
            }



        if(!loginCheck) {
            throw new Exception("Username does not exist");
        }
        else if(!passCheck) {
            throw new Exception("Password is not correct");
        }

        firstName = save.getFirstName();
        lastName = save.getLastName();
        emailName = save.getEmail();
        password = save.getPassword();
        cardNumber = save.getLibraryCardNum();
        User = save.getTypeOfUser();

    }

    public static void validatePassword(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("Password needs to be 8 characters");
        }

    }


    public static void main(String[] args) {

        new Start();
    }


}
