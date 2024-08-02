package prova.rastreamento.entrega.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.rastreamento.entrega.model.Pacote;
import prova.rastreamento.entrega.model.Rastreamento;
import prova.rastreamento.entrega.repository.PacoteRepository;
// import prova.rastreamento.entrega.repository.RastreamentoRepository;

@Service
public class RastreamentoService {
    
    // @Autowired
    // private RastreamentoRepository rastreamentoRepository;

    @Autowired
    private PacoteRepository pacoteRepository;

    // public Rastreamento adicionaRastreamento(Rastreamento rastreamento){

    //     return rastreamentoRepository.save(rastreamento);
    // }

    public List<Rastreamento> getRastreamentosByPacoteId(Long id){

        List<Rastreamento> rastreamentos = new ArrayList<>();

        Optional<Pacote> pacote = pacoteRepository.findById(id);

        if(pacote.isPresent()){

            pacote.get().getRastreamentos().forEach(ratreamento -> rastreamentos.add(ratreamento));
        }

        return rastreamentos;
        
    }
}
