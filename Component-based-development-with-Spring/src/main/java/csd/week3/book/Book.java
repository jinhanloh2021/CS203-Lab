package csd.week3.book;

import java.util.concurrent.atomic.AtomicLong;

public class Book {
    private static final AtomicLong counter = new AtomicLong();
    private Long id;
    private String title;

    public Book(){
        
    }

    public Book(String title){
        this.id = counter.incrementAndGet();
        this.title = title;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    
}