package csd.week3.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private ArrayList<Book> books = new ArrayList<Book>();
    // This is just a simple implementation for testing
    //A real-world implementation should be interacting with a database for books
    public BookServiceImpl(){
        books.add(new Book("To Kill a Mockingbird"));
        books.add(new Book("The Great Gatsby"));
        books.add(new Book("The Diary Of A Young Girl"));
    }
    
    @Override
    public List<Book> listBooks() {
        return books;
    }

    
    @Override
    public Book getBook(Long id){
        for(Book book : books){
            if(book.getId().equals(id))
                return book;
        }
        return null;
    }
    
  
    @Override
    public Book addBook(Book book) {
        Book newBook = new Book(book.getTitle());
        books.add(newBook);
        return newBook;
    }
    
    @Override
    public Book updateBook(Long id, Book newBookInfo){
        for(Book book : books){
            if(book.getId().equals(id)){
                book.setTitle(newBookInfo.getTitle());
                return book;
            }
        }
        
        return null;
    }

    /**
     * TODO: Activity 2
     * Add code to remove a book with the given id
     * 
     */
    @Override
    public Book deleteBook(Long id){
        // your code here
        return null;
    }
}