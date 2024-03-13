package fr.norsys.bookmanagement.repositories;

import fr.norsys.bookmanagement.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library getLibraryById(Long idLibrary);
}
