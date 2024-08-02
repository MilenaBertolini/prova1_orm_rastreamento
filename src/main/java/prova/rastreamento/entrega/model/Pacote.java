package prova.rastreamento.entrega.model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "id" , "id_bd"})
@EqualsAndHashCode(of = { "destinatario" })
@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bd;

    private String id;
    private String destinatario;
    private String status;

    @ManyToOne
    private Endereco endereco;

    @OneToMany()
    private List<Rastreamento> rastreamentos = new ArrayList<>();


    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao){

        this.status = novoStatus;

        Rastreamento rastreamento = new Rastreamento();

        rastreamento.setPacote(this);
        rastreamento.setStatus(novoStatus);
        rastreamento.setDataHora(dataHora);
        rastreamento.setLocalizacao(localizacao);
        
        this.rastreamentos.add(rastreamento);

    }

    public String consultarInformacoes(){

        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String info = "Destinatário: " + destinatario + "\n" + "Endereço: " + endereco.getRua() + ", " + endereco.getNumero() + ", " + endereco.getCidade() + ", " + endereco.getEstado() + " - " + endereco.getCep() + "\n" + "Status atual: " + status + "\n" + "Histórico de Rastreamento: \n";

        for (Rastreamento rasteramento : rastreamentos) {

            info += "Data e Hora: " + formataData.format(rasteramento.getDataHora()) + ", Status: " + rasteramento.getStatus() + ", Localização: " + rasteramento.getLocalizacao() + "\n";
            
        }

        return info;

    }

    
}
