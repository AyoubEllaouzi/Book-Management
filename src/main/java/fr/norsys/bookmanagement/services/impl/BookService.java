package fr.norsys.bookmanagement.services.impl;

import fr.norsys.bookmanagement.entities.Book;
import fr.norsys.bookmanagement.exceptions.ResourceNotFoundException;
import fr.norsys.bookmanagement.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookService implements fr.norsys.bookmanagement.services.BookService {
    private BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id,Book book) {
        Book oldBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("book id : "+id));

        oldBook.setTitle(book.getTitle());
        oldBook.setIsbn(book.getIsbn());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setGenre(book.getGenre());
        oldBook.setPublicationYear(book.getPublicationYear());
        return bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("book id : "+id));

        bookRepository.deleteById(id);

    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("book id : "+id));
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
}
