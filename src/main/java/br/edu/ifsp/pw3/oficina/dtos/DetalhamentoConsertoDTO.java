package br.edu.ifsp.pw3.oficina.dtos;

import br.edu.ifsp.pw3.oficina.models.Conserto;
import br.edu.ifsp.pw3.oficina.models.Mecanico;
import br.edu.ifsp.pw3.oficina.models.Veiculo;


public record DetalhamentoConsertoDTO(Long id, String data_entrada, String data_saida,
                                      Mecanico mecanico, Veiculo veiculo) {

    public DetalhamentoConsertoDTO(Conserto conserto){
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }
}


