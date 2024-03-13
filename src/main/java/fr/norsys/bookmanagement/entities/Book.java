package fr.norsys.bookmanagement.entities;

import fr.norsys.bookmanagement.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Invalid Title: Empty name")
    @NotNull(message = "Invalid Title: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Title: Must be of 3 - 30 characters")
    private String title;
    @ManyToOne
    private Author author;
    private int publicationYear;
    @NotEmpty(message = "isbn should not be empty or null")
    private String isbn;
    private Genre genre;

}
