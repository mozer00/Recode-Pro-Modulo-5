package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.model.Viagem;


@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>{

}
