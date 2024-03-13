package fr.norsys.bookmanagement.services.impl;

import fr.norsys.bookmanagement.entities.Library;
import fr.norsys.bookmanagement.exceptions.ResourceNotFoundException;
import fr.norsys.bookmanagement.repositories.LibraryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LibraryService implements fr.norsys.bookmanagement.services.LibraryService {
    private LibraryRepository libraryRepository;

    @Override
    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        Library updatedLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("library id : "+id));

        updatedLibrary.setName(library.getName());
        updatedLibrary.setBooks(library.getBooks());
        updatedLibrary.setLocation(library.getLocation());

        return libraryRepository.save(updatedLibrary);
    }

    @Override
    public void deleteLibrary(Long id) {
        libraryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("library id : "+id));

        libraryRepository.deleteById(id);
    }

    @Override
    public Library getLibrary(Long id) {
        return  libraryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("library id : "+id));
    }

    @Override
    public List<Library> getAllLibrary() {
        return libraryRepository.findAll();
    }
}
