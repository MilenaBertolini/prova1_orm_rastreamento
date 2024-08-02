package prova.rastreamento.entrega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova.rastreamento.entrega.model.Endereco;
import prova.rastreamento.entrega.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionaEndereco(Endereco endereco){

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllEnderecos(){

        List<Endereco> enderecos = new ArrayList<>();

        enderecoRepository.findAll().forEach(endereco -> enderecos.add(endereco));

        return enderecos;
    }
    

}
