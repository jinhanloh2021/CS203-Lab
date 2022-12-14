package csd.week6.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock // mocks repository
    private BookRepository books;

    @InjectMocks // dependency in BookRepository. Inject mock BookService
    private BookServiceImpl bookService;

    @Test
    void addBook_NewTitle_ReturnSavedBook() {
        // arrange //create new Book***
        Book book = new Book("This is a New Title");
        // mock the "findbytitle" operation
        when(books.findByTitle(any(String.class))).thenReturn(new ArrayList<Book>());
        // mock the "save" operation
        when(books.save(any(Book.class))).thenReturn(book);

        // act ***
        Book savedBook = bookService.addBook(book);

        // assert ***
        assertNotNull(savedBook);
        verify(books).findByTitle(book.getTitle()); // addBook invokes findByTitle() and save()
        verify(books).save(book);
    }

    /**
     * TODO: Activity 1 (Week 6)
     * Write a test case: when adding a new book but the title already exists
     * The test case should pass if BookServiceImpl.addBook(book)
     * returns null (can't add book), otherwise it will fail.
     * Remember to include suitable "verify" operations
     * 
     */
    @Test
    void addBook_SameTitle_ReturnNull() {
        // arrange //create new Book***
        Book book = new Book("This is a Same Title");
        // mock the "findbytitle" operation
        List<Book> mockReturnedList = new ArrayList<Book>();
        mockReturnedList.add(book);
        when(books.findByTitle(any(String.class))).thenReturn(mockReturnedList);
        // mock the "save" operation
        // when(books.save(any(Book.class))).thenReturn(book);

        // act ***
        Book savedBook = bookService.addBook(book);

        // assert ***
        assertNull(savedBook);
        verify(books).findByTitle(book.getTitle()); // check that addBook invokes findByTitle()
        // verify(books).save(book);
    }

    @Test
    void updateBook_NotFound_ReturnNull() {
        Book book = new Book("Updated Title of Book");
        Long bookId = 10L;
        when(books.findById(bookId)).thenReturn(Optional.empty());

        Book updatedBook = bookService.updateBook(bookId, book);

        assertNull(updatedBook);
        verify(books).findById(bookId);
    }

}