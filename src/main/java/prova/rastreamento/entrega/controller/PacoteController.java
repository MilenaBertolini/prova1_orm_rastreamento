package prova.rastreamento.entrega.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prova.rastreamento.entrega.model.Pacote;
import prova.rastreamento.entrega.service.PacoteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @PostMapping
    public Pacote criaPacote(@RequestBody Pacote pacote) {

        return pacoteService.adicionaPacote(pacote);
        
    }

    @PutMapping("/{id}")
    public Pacote atualizaPacote(@PathVariable Long id, @RequestBody Pacote pacote) {
        
        return pacoteService.updatePacote(id, pacote);
    }

    @GetMapping("/{id}")
    public Pacote getPacote(@PathVariable Long id) {
        
        return pacoteService.getPacoteById(id);
    }
    
    @GetMapping
    public List<Pacote> pacotes () {
        
        return pacoteService.getAllPacotes();
    }
    
    @DeleteMapping("/{id}")
    public void deletePacote(@PathVariable Long id){

        pacoteService.deletePacote(id);

    }
    
}
