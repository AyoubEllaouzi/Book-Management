package fr.norsys.bookmanagement.controllers;

import fr.norsys.bookmanagement.constants.BookConstants;
import fr.norsys.bookmanagement.constants.LibraryConstants;
import fr.norsys.bookmanagement.dto.ResponseDto;
import fr.norsys.bookmanagement.entities.Book;
import fr.norsys.bookmanagement.entities.Library;
import fr.norsys.bookmanagement.services.LibraryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/libraries")
public class LibraryController {
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveLibrary(@Valid @RequestBody Library library) {
        libraryService.saveLibrary(library);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LibraryConstants.STATUS_201,LibraryConstants.MESSAGE_201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto>  updateLibrary(Long id, @Valid @RequestBody Library library) {
        libraryService.updateLibrary(id, library);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LibraryConstants.STATUS_200,LibraryConstants.MESSAGE_200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LibraryConstants.STATUS_200,LibraryConstants.MESSAGE_200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library>  getLibrary(@PathVariable Long id) {
        Library library = libraryService.getLibrary(id);
        return ResponseEntity.status(HttpStatus.OK).body(library);
    }

    @GetMapping
    public ResponseEntity<List<Library>> getAllLibrary() {
        List<Library> libraries =  libraryService.getAllLibrary();
        return ResponseEntity.status(HttpStatus.OK).body(libraries);
    }

}
