package fr.norsys.bookmanagement.controllers;

import fr.norsys.bookmanagement.constants.AuthorConstants;
import fr.norsys.bookmanagement.constants.BookConstants;
import fr.norsys.bookmanagement.dto.ResponseDto;
import fr.norsys.bookmanagement.entities.Author;
import fr.norsys.bookmanagement.services.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
@Validated
public class AuthorController {
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveAuthor(@Valid @RequestBody Author author) {
        authorService.saveAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AuthorConstants.STATUS_201,AuthorConstants.MESSAGE_201));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAuthor(@PathVariable Long id, @Valid @RequestBody Author updatedAuthor) {
        authorService.updateAuthor(id, updatedAuthor);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AuthorConstants.STATUS_200,AuthorConstants.MESSAGE_200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteAuthor(@PathVariable Long id) {
            authorService.deleteAuthor(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AuthorConstants.STATUS_200,AuthorConstants.MESSAGE_200));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Author author = authorService.getAuthor(id);
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }
}
