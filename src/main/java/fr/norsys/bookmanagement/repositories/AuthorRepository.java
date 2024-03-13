package fr.norsys.bookmanagement.repositories;

import fr.norsys.bookmanagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorById(Long idAuthor);
}
