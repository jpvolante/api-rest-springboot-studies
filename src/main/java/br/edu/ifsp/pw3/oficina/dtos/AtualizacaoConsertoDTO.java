package br.edu.ifsp.pw3.oficina.dtos;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoConsertoDTO(
        @NotNull
        Long id,
        String data_saida,
        MecanicoRecordDTO mecanico) { }

