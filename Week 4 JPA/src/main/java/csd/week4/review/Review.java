package csd.week4.review;

import javax.persistence.*;
import csd.week4.book.Book;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Review {
    private  @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Long id;
    private String review;

    @ManyToOne
    // the column "book_id" will be in the auto-generated table "review"
    // nullable = false: add not-null constraint to the database column "book_id"
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}