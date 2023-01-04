package userbookinf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class Admin {
	
	long ctr=0;
	Scanner sc1 = new Scanner(System.in);
	private static Logger logger = Logger.getLogger("Admin");
	
	public void displayMenu(){
		System.out.println("1.Add a new book");
		System.out.println("2.Delete a book");
		System.out.println("3.Update a book");
		System.out.println("4.Display all books");
		System.out.println("5.Total number of books available");
		System.out.println("6.Books under autobiography genre");
		System.out.println("7.Filter");
	}
	public int operation(int n) {
		try {
			MongoClient mongoClient = new MongoClient("localhost",27017);
			MongoDatabase db = mongoClient.getDatabase("administration");
			MongoCollection<Document> table1 = db.getCollection("bookinf");
			Document doc = new Document();
			switch(n) {
			case 1:
				System.out.println("Enter book id");
				int bookid = sc1.nextInt();
				sc1.nextLine();
				System.out.println("Name of the book");
				String name = sc1.nextLine();
				System.out.println("Author of the book");
				String author_name = sc1.nextLine();
				System.out.println("Genre of the book");
				String Genre = sc1.nextLine();
				System.out.println("Price of the book");
				int price = sc1.nextInt();
				System.out.println("Selling quantity");
				int totalBooksSold = sc1.nextInt();
				doc.append("Bookid", bookid);
				doc.append("Name", name);
				doc.append("Author", author_name);
				doc.append("Genre", Genre);
				doc.append("Price", price);
				doc.append("Quantity_Sold", totalBooksSold);
				table1.insertOne(doc);
				System.out.println("Book has been added to the database");
				break;
				
			case 2:
				System.out.println("Enter the id of the book");
				int bookid1 = sc1.nextInt();
				table1.deleteOne(Filters.eq("Bookid", bookid1));
				System.out.println("Book has been deleted from the database");
				break;
			case 3:
				System.out.println("Enter the Id of the book to be updated");
				int bookid2 = sc1.nextInt();
				BasicDBObject query = new BasicDBObject();
				query.put("Bookid", bookid2);
				System.out.println("Enter any one option to be updated");
				System.out.println("1.Bookid");
				System.out.println("2.Name");
				System.out.println("3.Author");
				System.out.println("4.Price");
				System.out.println("5.Quantity_Sold");
				System.out.println("6.Genre");
				int m = sc1.nextInt();
				switch(m) {
				case 1:
					System.out.println("Enter the updated id of the book");
					int up_bookid = sc1.nextInt();
					BasicDBObject updateQuery = new BasicDBObject();
					updateQuery.append("$set",new BasicDBObject().append("Bookid", up_bookid));
					table1.updateOne(query, updateQuery);
					System.out.println("Book ID updated");
					break;
				case 2:
					System.out.println("Enter the updated name of the book");
					String up_name = sc1.next();
					BasicDBObject updateQuery1 = new BasicDBObject();
					updateQuery1.append("$set",new BasicDBObject().append("Name", up_name));
					table1.updateOne(query, updateQuery1);
					System.out.println("Book name updated");
					break;
				case 3:
					System.out.println("Enter the updated Author name of the book");
					String up_author = sc1.next();
					BasicDBObject updateQuery2 = new BasicDBObject();
					updateQuery2.append("$set",new BasicDBObject().append("Author", up_author));
					table1.updateOne(query, updateQuery2);
					System.out.println("Author name updated");
					break;
				case 4:
					System.out.println("Enter the updated price of the book");
					int up_price = sc1.nextInt();
					BasicDBObject updateQuery3 = new BasicDBObject();
					updateQuery3.append("$set",new BasicDBObject().append("Price", up_price));
					table1.updateOne(query, updateQuery3);
					System.out.println("Price of the book updated");
					break;
				case 5:
					System.out.println("Enter the updated selling quantity of the book");
					int up_quantitySold = sc1.nextInt();
					BasicDBObject updateQuery4 = new BasicDBObject();
					updateQuery4.append("$set",new BasicDBObject().append("Quantity_Sold", up_quantitySold));
					table1.updateOne(query, updateQuery4);
					System.out.println("Selling quantity updated");
					break;
				case 6:
					System.out.println("Enter the updated genre of the book");
					String up_genre = sc1.next();
					BasicDBObject updateQuery5 = new BasicDBObject();
					updateQuery5.append("$set",new BasicDBObject().append("Genre", up_genre));
					table1.updateOne(query, updateQuery5);
					System.out.println("Genre of the book updated");
					break;
				default:
					System.out.println("Option entered is invalid");
					break;
				}
				break;
			case 4:
				MongoCursor<Document> cursor = table1.find().iterator();
		        while (cursor.hasNext()) {
		        	Document a = cursor.next();
		            System.out.println("Book ID: "+a.get("Bookid"));
		            System.out.println("Name of the book: "+a.get("Name"));
		            System.out.println("Author of the book: "+a.get("Author"));
		            System.out.println("Genre of the book: "+a.get("Genre"));
		            System.out.println("Price of the book: "+a.get("Price"));
		            System.out.println("Total amount of the books sold: "+a.get("Quantity_Sold"));
		            System.out.println();
		        }
				break;
			case 5:
				ctr=table1.count();
				System.out.println("Total books available: "+ctr);
				break;
			case 6:
				MongoCursor<Document> cursor1 = table1.find().iterator();
				while(cursor1.hasNext()) {
					Document b = cursor1.next();
					String s = b.getString("Genre");
					if(s.equalsIgnoreCase("Autobiography")) {
						System.out.println("Book ID: "+b.get("Bookid"));
						System.out.println("Name of the book: "+b.get("Name"));
			            System.out.println("Author of the book: "+b.get("Author"));
			            System.out.println("Genre of the book: "+b.get("Genre"));
			            System.out.println("Price of the book: "+b.get("Price"));
			            System.out.println("Total amount of the books sold: "+b.get("Quantity_Sold"));
					}
				}
				break;
			case 7:
				System.out.println("1.Sort Price");
				System.out.println("2.Sort Quantity Sold");
				int n1 = sc1.nextInt();
				switch(n1) {
				case 1:
					System.out.println("1.Price Low to High");
					System.out.println("2.Price High to Low");
					int n2 = sc1.nextInt();
					if(n2==1) {
						List<Document> results = new ArrayList<>();
						table1.find().sort(ascending("Price")).into(results);
						for (Document result : results) {
						      System.out.println(result.toJson());
						}
					}
					else {
						List<Document> results = new ArrayList<>();
						table1.find().sort(descending("Price")).into(results);
						for (Document result : results) {
						      System.out.println(result.toJson());
						}
					}
					break;
				case 2:
					System.out.println("1.Quantity sold Low to High");
					System.out.println("2.Quantity sold High to Low");
					int n3 = sc1.nextInt();
					if(n3==1) {
						List<Document> results = new ArrayList<>();
						table1.find().sort(ascending("Quantity_Sold")).into(results);
						for (Document result : results) {
						      System.out.println(result.toJson());
						}
					}
					else {
						List<Document> results = new ArrayList<>();
						table1.find().sort(descending("Quantity_Sold")).into(results);
						for (Document result : results) {
						      System.out.println(result.toJson());
						}
					}
					break;
				}
				break;
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Press 0 to Exit");
		int ex = sc1.nextInt();
		return ex;
	}
	
	

}
