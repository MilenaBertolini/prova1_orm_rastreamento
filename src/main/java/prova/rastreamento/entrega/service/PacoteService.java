package prova.rastreamento.entrega.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.rastreamento.entrega.model.Pacote;
import prova.rastreamento.entrega.repository.PacoteRepository;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public Pacote adicionaPacote(Pacote pacote){

        return pacoteRepository.save(pacote);
    }

    public Pacote updatePacote(Long id, Pacote pacote){

        Optional<Pacote> existePacote = pacoteRepository.findById(id);

        if(existePacote.isPresent()){

            Pacote pacoteExistente = existePacote.get();

            pacoteExistente.setDestinatario(pacote.getDestinatario());
            pacoteExistente.setStatus(pacote.getStatus());
            pacoteExistente.setEndereco(pacote.getEndereco());

            return pacoteRepository.save(pacoteExistente);
        }

        return null;
    }

    public Pacote getPacoteById(Long id){

        Optional<Pacote> existePacote = pacoteRepository.findById(id);

        if(existePacote.isPresent()){

            return existePacote.get();
        }

        return null;
    }
    
    public List<Pacote> getAllPacotes(){

        List<Pacote> pacotes = new ArrayList<>();

        pacoteRepository.findAll().forEach(pacote -> pacotes.add(pacote));

        return pacotes;
    }

    public boolean deletePacote(Long id) {

        try {
            
            pacoteRepository.deleteById(id);

            return true;
            
        } catch (Exception e) {
            
            return false;
        }
        
    }
}
