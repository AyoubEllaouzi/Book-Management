package fr.norsys.bookmanagement.services;

import fr.norsys.bookmanagement.entities.Book;
import fr.norsys.bookmanagement.entities.Library;

import java.util.List;

public interface LibraryService {
    Library saveLibrary(Library library);
    Library updateLibrary(Long id, Library library);
    void deleteLibrary(Long id);
    Library getLibrary(Long id);
    List<Library> getAllLibrary();
}
