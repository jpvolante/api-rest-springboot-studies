package br.edu.ifsp.pw3.oficina.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoRecordDTO(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        String cor,

        @Pattern(regexp = "^\\d{4}$", message = "Ano inválido. Use o formato xxxx")
        @NotBlank
        String ano) {
}