package fr.norsys.bookmanagement.repositories;

import fr.norsys.bookmanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookById(Long idBook);
}
