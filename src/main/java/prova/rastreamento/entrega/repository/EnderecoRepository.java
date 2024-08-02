package prova.rastreamento.entrega.repository;

import prova.rastreamento.entrega.model.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    
}
