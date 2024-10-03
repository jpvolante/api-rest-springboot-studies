package br.ifsp.edu.pw3.api.veiculo;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String model;
    private int ano;
    public Veiculo(DadosCadastroVeiculo dados) {
        this.marca = dados.marca();
        this.model = dados.model();
        this.ano = dados.ano();
    }
}