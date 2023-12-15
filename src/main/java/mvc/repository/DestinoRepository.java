package mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.model.Destino;


@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
