package csd.week5.review;

import javax.persistence.*;
import javax.validation.constraints.*;

import csd.week5.book.Book;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Review {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    /**
     * TODO: Activity 1 - Java Bean Validation
     * Add constraints here to ensure the review is not null,
     * and should be at least 10 characters long.
     */
    // your code here
    @NotNull(message = "Review should not be null")
    @Size(min = 10, message = "Review must be at leats 10 characters.")
    private String review;

    // the column "book_id" will be in the auto-generated table "review"
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false) // foreign key attribute "book_id" cannot be null.
    private Book book;
}