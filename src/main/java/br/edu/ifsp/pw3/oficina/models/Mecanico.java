package br.edu.ifsp.pw3.oficina.models;


import br.edu.ifsp.pw3.oficina.dtos.MecanicoRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome_mecanico;
    private String anos_experiencia;

    public Mecanico(MecanicoRecordDTO dados){
        this.nome_mecanico = dados.nome_mecanico();
        this.anos_experiencia = dados.anos_experiencia();
    }

    public void atualizarInformacoes(MecanicoRecordDTO dados){
        if(dados.nome_mecanico() != null){
            this.nome_mecanico = dados.nome_mecanico();
        }
        if(dados.anos_experiencia() != null){
            this.anos_experiencia = dados.anos_experiencia();
        }
    }

    public String getNome_mecanico() {
        return nome_mecanico;
    }

    public void setNome_mecanico(String nome_mecanico) {
        this.nome_mecanico = nome_mecanico;
    }

    public void setAnos_experiencia(String anos_experiencia) {
        this.anos_experiencia = anos_experiencia;
    }
}
