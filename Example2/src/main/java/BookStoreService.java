import java.sql.*;

public class BookStoreService {
    Connection connection;

    public void persistBook(Book book)
            throws ClassNotFoundException, SQLException {
        System.out.println("Inserting Book into DB");
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/bookstore",
                            "root",
                            "Batman@123");
        }
//https://github.com/abhijith142/gat.git
        PreparedStatement insertPublisher =
                connection.prepareStatement(
                        "INSERT INTO Publisher(id, publisherName) values(?,?)");
        insertPublisher.setString(
                1,
                book.getPublisher().getId());
        insertPublisher.setString(
                2,
                book.getPublisher().getPublisherName());

        insertPublisher.executeUpdate();
        insertPublisher.close();

        PreparedStatement insertBook = connection
                .prepareStatement(
                        "INSERT INTO Book(isbn, bookName, pub_id) values(?,?,?)");
        insertBook.setString(1,
                book.getIsbn());
        insertBook.setString(2,
                book.getBookName());
        insertBook.setString(3,
                book.getPublisher().getId());

        insertBook.executeUpdate();
        insertBook.close();

        System.out.println("Inserted Book into DB");
    }

}

//    public Book retrieveBook(String isbn) throws ClassNotFoundException, SQLException {
//        System.out.println("Getting Book from DB");
//        if (connection == null) {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "Batman@123");
//        }
//        PreparedStatement selectStatement = connection.prepareStatement("Select * from Book, Publisher where Book.pub_id = Publisher.id and Book.isbn = ?");
//        selectStatement.setString(1, isbn);
//
//        ResultSet resultSet = selectStatement.executeQuery();
//        if(resultSet.next()) {
//            Book book = new Book();
//            Publisher publisher = new Publisher();
//            String bookIsbn = resultSet.getString("isbn");
//            String bookName = resultSet.getString("bookName");
//            String pubId = resultSet.getString("id");
//            String publisherName = resultSet.getString("publisherName");
//
//            publisher.setId(pubId);
//            publisher.setPublisherName(publisherName);
//            book.setIsbn(bookIsbn);
//            book.setBookName(bookName);
//            book.setPublisher(publisher);
//            return book;
//        }
//
//        return null;
//
//    }
//}
