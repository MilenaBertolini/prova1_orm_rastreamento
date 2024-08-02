package prova.rastreamento.entrega.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@ToString(exclude = { "id" })
@EqualsAndHashCode(of = { "dataHora" })
@Entity
public class Rastreamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataHora;
    private String status;
    private String localizacao;

    @ManyToOne
    private Pacote pacote;

    public String getResumo() {

       SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        return "Data e Hora: " + formataData.format(dataHora) + ", Status: " + status + ", Localização: " + localizacao;
    }
}
