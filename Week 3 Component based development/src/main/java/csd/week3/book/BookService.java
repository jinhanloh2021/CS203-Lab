package csd.week3.book;

import java.util.List;

/**
 * Here a service interface is declared to capture what are needed for the business logic of the application.
 * We can provide different implementations of this interface later.
  */
public interface BookService {
    List<Book> listBooks();
    Book getBook(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    Book deleteBook(Long id);
}