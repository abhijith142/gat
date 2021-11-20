import java.sql.SQLException;

public class Demo {
    BookStoreService bookStoreService =
            new BookStoreService();
    public static void main(String[] args)
            throws SQLException,
            ClassNotFoundException {
        Demo demo = new Demo();
        demo.createBook();
    }

    public void createBook() throws SQLException, ClassNotFoundException {
        Publisher publisher = new Publisher("pub1", "publisher 1");

        Book book = new Book("isbn1", "Book 1", publisher);
        bookStoreService.persistBook(book);

//        Book retrievedBook = bookStoreService.retrieveBook("isbn1");
//        System.out.println(retrievedBook);
    }
}
