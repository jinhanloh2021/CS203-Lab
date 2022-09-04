package csd.week4.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import csd.week4.review.Review;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
    private String title;
    
    // one book has many reviews, the "mappedBy" attribute references the "book" property in the Review class
    // CascadeType.ALL: to propagate (cascade) all persistence operations to relating entities
    // E.g., remove a book -> all associated reviews removed
    // orphanRemoval = true: any disconnected entity instances are automatically removed
    // E.g., to clean up dependent objects (reviews) that should not exist without a refererence from the owner object (book)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    // Ignore the field in both JSON serialization and deserialization
    private List<Review> reviews;
    
    public Book(String title){
        this.title = title;
    }
    
}