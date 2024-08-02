package prova.rastreamento.entrega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prova.rastreamento.entrega.model.Pacote;

@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long>{

}
