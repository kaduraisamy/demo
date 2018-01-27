package guru.springframework.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kartdura on 1/27/2018.
 */
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;
    String isbn;
    String publisher;
    @ManyToMany(mappedBy = "books")
    Set<Author> author = new HashSet<>();

    public Books(String title, String isbn, String publisher, Set<Author> authorSet) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = authorSet;
    }

    public Books(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> authorSet) {
        this.author = authorSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        return !(id != null ? !id.equals(books.id) : books.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author=" + author +
                '}';
    }
}
