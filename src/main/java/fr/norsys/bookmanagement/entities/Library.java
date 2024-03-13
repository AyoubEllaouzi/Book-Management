package fr.norsys.bookmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name should not be empty or null")
    @Size(min = 6 ,message = "the length of the name should greater than 5")
    private String name;
    @NotEmpty(message = "location should not be empty or null")
    @Size(min = 6 ,message = "the length of the location should greater than 5")
    private String location;
    @OneToMany
    private List<Book> books;
}
