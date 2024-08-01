package prova.rastreamento.entrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@EqualsAndHashCode(of = { "numero" })
@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;


    public String getEnderecoCompleto() {

        return "Endereço Completo: " + rua + ", " + numero + ", " + cidade + ", " + estado + " - " + cep;
    }
}
