package br.edu.ifsp.pw3.oficina.dtos;

import jakarta.validation.constraints.NotBlank;

public record MecanicoRecordDTO(
        @NotBlank
        String nome_mecanico,

        String anos_experiencia) {
}


