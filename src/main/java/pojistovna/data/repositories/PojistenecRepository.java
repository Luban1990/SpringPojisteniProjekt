package pojistovna.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pojistovna.data.entity.PojistenecEntity;

public interface PojistenecRepository extends JpaRepository<PojistenecEntity, Long> {
// Napojení na databázy, JpaRepository automaticky generuje CRUD.


}
