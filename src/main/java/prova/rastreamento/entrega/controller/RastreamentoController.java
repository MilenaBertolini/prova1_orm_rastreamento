package prova.rastreamento.entrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prova.rastreamento.entrega.model.Rastreamento;
import prova.rastreamento.entrega.service.RastreamentoService;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {
    
    @Autowired
    private RastreamentoService rastreamentoService;

    // @PostMapping
    // public Rastreamento criaRastreamento(@RequestBody Rastreamento rastreamento) {
        
    //     return rastreamentoService.adicionaRastreamento(rastreamento);
    // }
    

    @GetMapping("/{id}")
    public List<Rastreamento> allRastreamentosPorPacote(@PathVariable Long id){
        
        return rastreamentoService.getRastreamentosByPacoteId(id);
    }

}
