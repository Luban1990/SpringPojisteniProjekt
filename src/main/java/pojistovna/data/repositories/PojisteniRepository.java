package pojistovna.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pojistovna.data.entity.PojisteniEntity;

import java.util.List;

public interface PojisteniRepository extends JpaRepository<PojisteniEntity,Long> {

    // // Napojení na databázy, JpaRepository automaticky generuje CRUD.

    // Najde všechna pojištění pro daného pojištěnce podle jeho ID
    List<PojisteniEntity> findByPojistenec_Id(Long pojistenecId);


}
