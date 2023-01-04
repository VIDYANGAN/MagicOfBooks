package userbookinf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String userName;
    private String password;
    private String emailId;
    private int userId;
    ArrayList<Book> newBooks = new ArrayList<Book>();
    ArrayList<Book> favouriteBooks = new ArrayList<Book>();
    ArrayList<Book> completedBooks = new ArrayList<Book>();
    Map<String, ArrayList<Book>> userBooks = new HashMap<String, ArrayList<Book>>();

    public String getPassword() {
        return password;
    }

    public ArrayList<Book> getCompletedBooks() {
        return completedBooks;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public ArrayList<Book> getNewBooks() {
        return newBooks;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setCompletedBooks(ArrayList<Book> completedBooks) {
        this.completedBooks = completedBooks;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setFavouriteBooks(ArrayList<Book> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public void setNewBooks(ArrayList<Book> newBooks) {
        this.newBooks = newBooks;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
