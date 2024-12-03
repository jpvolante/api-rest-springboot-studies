package br.edu.ifsp.pw3.oficina.models;

import br.edu.ifsp.pw3.oficina.dtos.AtualizacaoConsertoDTO;
import br.edu.ifsp.pw3.oficina.dtos.ConsertoRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_entrada;
    private String data_saida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(ConsertoRecordDTO dados){
        this.ativo = true;
        this.data_entrada = dados.data_entrada();
        this.data_saida = dados.data_saida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
    }


    public void atualizarInformacoes(AtualizacaoConsertoDTO dados){
        if(dados.data_saida() != null){
            this.data_saida = dados.data_saida();
        }
        if(dados.mecanico() != null){
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir(){
        this.ativo = false;
    }


    public Long getId() {
        return id;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }
}
