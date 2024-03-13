package fr.norsys.bookmanagement.services;

import fr.norsys.bookmanagement.entities.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    Book updateBook(Long id , Book book);
    void deleteBook(Long id);
    Book getBook(Long id);
    List<Book> getAllBook();
}
