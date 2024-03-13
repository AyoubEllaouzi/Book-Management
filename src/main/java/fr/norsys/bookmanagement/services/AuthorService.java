package fr.norsys.bookmanagement.services;

import fr.norsys.bookmanagement.entities.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    Author updateAuthor(Long id, Author updatedAuthor);
    void deleteAuthor(Long id);
    Author getAuthor(Long id);
    List<Author> getAllAuthor();
}
