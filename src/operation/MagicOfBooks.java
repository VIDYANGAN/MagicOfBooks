package operation;

import userbookinf.Book;
import userbookinf.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicOfBooks {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> userlst = new ArrayList<User>();
    ArrayList<Book> booklst = new ArrayList<Book>();
    static int userid = 1000;
    public void registration(){
        try{
        	sc.nextLine();
            System.out.println("Enter Email Id: ");
            String email = sc.nextLine();
            System.out.println("Enter Password: ");
            String pass = sc.nextLine();
            System.out.println("Enter user name: ");
            String name = sc.nextLine();
            User a = new User();
            a.setEmailId(email);
            a.setPassword(pass);
            a.setUserName(name);
            a.setUserId(userid);
            userid++;
            userlst.add(a);
            System.out.println("User registered Successfully");
        }
        catch (Exception e){
            System.out.println("User registration failed");
        }
    }
    public void login(){
        try{
        	sc.nextLine();
            System.out.println("Enter Email Id: ");
            String s1 =sc.nextLine();
            System.out.println("Enter user name: ");
            String s2 = sc.nextLine();
            System.out.println("Enter password: ");
            String s3 = sc.nextLine();
            for(User b : userlst){
                if (b.getUserName().equals(s2) && b.getPassword().equals(s3) && b.getEmailId().equals(s1)){
                    System.out.println("Welcome "+ b.getUserName());
                }
            }
        }
        catch (Exception e){
            System.out.println("Login Failed");
        }
    }
    public void addnewbook(){
        try{
            System.out.println("Enter book name");
            String s1=sc.nextLine();
            System.out.println("Enter author name");
            String s2=sc.nextLine();
            System.out.println("Enter book description");
            String s3=sc.nextLine();
            System.out.println("Enter book id");
            int id = sc.nextInt();
            Book newbk = new Book();
            newbk.setBookName(s1);
            newbk.setAuthorName(s2);
            newbk.setBookDescription(s3);
            newbk.setBookId(id);
            userlst.get(0).getNewBooks().add(newbk);
            booklst.add(newbk);
            System.out.println("Book added successfully");
        }
        catch (Exception e){
            System.out.println("Book addition failed");
        }
    }
    public void addfavoritebook(){
        try {
            System.out.println("Enter book name");
            String s1=sc.nextLine();
            System.out.println("Enter author name");
            String s2=sc.nextLine();
            System.out.println("Enter book description");
            String s3=sc.nextLine();
            System.out.println("Enter book id");
            int id = sc.nextInt();
            Book newbk = new Book();
            newbk.setBookName(s1);
            newbk.setAuthorName(s2);
            newbk.setBookDescription(s3);
            newbk.setBookId(id);
            userlst.get(0).getFavouriteBooks().add(newbk);
            booklst.add(newbk);
            System.out.println("Book added successfully");
        }
        catch (Exception e){
            System.out.println("Book addition failed");
        }
    }
    public void addcompletedbooks(){
        try {
            System.out.println("Enter book name");
            String s1=sc.nextLine();
            System.out.println("Enter author name");
            String s2=sc.nextLine();
            System.out.println("Enter book description");
            String s3=sc.nextLine();
            System.out.println("Enter book id");
            int id = sc.nextInt();
            Book newbk = new Book();
            newbk.setBookName(s1);
            newbk.setAuthorName(s2);
            newbk.setBookDescription(s3);
            newbk.setBookId(id);
            userlst.get(0).getCompletedBooks().add(newbk);
            booklst.add(newbk);
            System.out.println("Book added successfully");
        }
        catch (Exception e){
            System.out.println("Book addition failed");
        }
    }

    public void displaybooks(){
        System.out.println("New Books:");
        for (Book bk:userlst.get(0).getNewBooks()) {
            System.out.println(bk.getBookName());
        }
        System.out.println("Favourite Books:");
        for (Book bk:userlst.get(0).getFavouriteBooks()){
            System.out.println(bk.getBookName());
        }
        System.out.println("Completed Books");
        for (Book bk:userlst.get(0).getCompletedBooks()){
            System.out.println(bk.getBookName());
        }
    }

    public void chkavailability(){
        try{
            System.out.println("Enter book ID: ");
            int bookid = sc.nextInt();
            for (Book bk:booklst){
                if(bk.getBookId()==bookid){
                    System.out.println("Book Available");
                }
            }
        }
        catch (Exception e){
            System.out.println("Book not available");
        }
    }

    public void displaybkdetails(){
        try {
            System.out.println("Enter book ID: ");
            int bookid = sc.nextInt();
            for (Book bk: userlst.get(0).getNewBooks()){
                if (bk.getBookId()==bookid){
                    System.out.println("Book Name: " + bk.getBookName());
                    System.out.println("Author Name: " + bk.getAuthorName());
                    System.out.println("Book Description: " + bk.getBookDescription());
                }
            }
            for (Book bk: userlst.get(0).getFavouriteBooks()){
                if(bk.getBookId()==bookid){
                    System.out.println("Book Name: " + bk.getBookName());
                    System.out.println("Author Name: " + bk.getAuthorName());
                    System.out.println("Book Description: " + bk.getBookDescription());
                }
            }
            for (Book bk: userlst.get(0).getCompletedBooks()){
                if(bk.getBookId()==bookid){
                    System.out.println("Book Name: " + bk.getBookName());
                    System.out.println("Author Name: " + bk.getAuthorName());
                    System.out.println("Book Description: " + bk.getBookDescription());
                }
            }
        }
        catch (Exception e){
            System.out.println("Book not available");
        }
    }

}
