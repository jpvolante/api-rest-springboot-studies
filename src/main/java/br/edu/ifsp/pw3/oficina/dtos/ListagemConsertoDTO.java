package br.edu.ifsp.pw3.oficina.dtos;

import br.edu.ifsp.pw3.oficina.models.Conserto;
import br.edu.ifsp.pw3.oficina.models.Veiculo;

public record ListagemConsertoDTO(Long id, String data_entrada, String data_saida, String nome_mecanico, String marca, String modelo) {
    public ListagemConsertoDTO(Conserto conserto){
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(),
                conserto.getMecanico().getNome_mecanico(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
