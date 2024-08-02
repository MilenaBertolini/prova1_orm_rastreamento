package prova.rastreamento.entrega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import prova.rastreamento.entrega.model.Rastreamento;

@Repository
public interface RastreamentoRepository extends CrudRepository<Rastreamento, Long>{

}
