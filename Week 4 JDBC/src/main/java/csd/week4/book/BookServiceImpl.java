package csd.week4.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This implementation is meant for business logic, which could be added later
 * Currently, it does not have much in terms of the business logic yet
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository books;

    public BookServiceImpl(BookRepository books) {

        this.books = books;

    }

    @Override
    public List<Book> listBooks() {
        return books.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> b = books.findById(id);
        if (b.isPresent()) // from Optional class
            return b.get();
        else
            return null;

    }

    @Override
    public Book addBook(Book book) {
        book.setId(books.save(book));
        return book;
    }

    /**
     * TODO: Activity 1 - Implement the update method
     * This method should return the updated book, or null if the given id is not
     * found
     * 
     */
    @Override
    public Book updateBook(Long id, Book newBookInfo) {
        // your code here
        // you should also return an instance of Book, or null
        int rowsAffected = books.update(newBookInfo);
        return rowsAffected == 0 ? null : newBookInfo;
    }

    @Override
    public int deleteBook(Long id) {
        return books.deleteById(id);
    }
}