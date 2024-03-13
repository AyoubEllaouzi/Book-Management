package fr.norsys.bookmanagement.controllers;

import fr.norsys.bookmanagement.constants.BookConstants;
import fr.norsys.bookmanagement.dto.ResponseDto;
import fr.norsys.bookmanagement.entities.Book;
import fr.norsys.bookmanagement.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
@Slf4j
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveBook(@Valid @RequestBody Book book) {
            bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(BookConstants.STATUS_201,BookConstants.MESSAGE_201));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateBook(@PathVariable Long id,@Valid @RequestBody Book updatedBook) {
            bookService.updateBook(id, updatedBook);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookConstants.STATUS_200,BookConstants.MESSAGE_200));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(BookConstants.STATUS_200,BookConstants.MESSAGE_200));

    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);

    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(books);

    }


}
