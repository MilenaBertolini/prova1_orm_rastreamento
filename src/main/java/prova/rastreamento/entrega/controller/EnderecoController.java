package prova.rastreamento.entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import prova.rastreamento.entrega.model.Endereco;
import prova.rastreamento.entrega.service.EnderecoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco criaEndereco(@RequestBody Endereco endereco) {
        
        return enderecoService.adicionaEndereco(endereco);
    }
    

    @GetMapping
    public List<Endereco> getAllEnderecos() {
        
        return enderecoService.getAllEnderecos();
    }
    
    
}
