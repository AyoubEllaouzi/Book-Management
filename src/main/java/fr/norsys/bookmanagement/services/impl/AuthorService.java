package fr.norsys.bookmanagement.services.impl;

import fr.norsys.bookmanagement.entities.Author;
import fr.norsys.bookmanagement.exceptions.ResourceNotFoundException;
import fr.norsys.bookmanagement.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
//@RequiredArgsConstructor  =>  private final AuthorRepository authorRepository;
public class AuthorService implements fr.norsys.bookmanagement.services.AuthorService {
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("author id : "+id));

        authorRepository.deleteById(id);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("author id : "+id));
    }

    @Override
    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("author id : "+id));

        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setNationality(updatedAuthor.getNationality());

        return authorRepository.save(existingAuthor);
    }

    @Override
    public List<Author> getAllAuthor() { //Page<Author> et Pageable
        return authorRepository.findAll();
    }
}
