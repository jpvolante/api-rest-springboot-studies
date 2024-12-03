package br.edu.ifsp.pw3.oficina.dtos;

import br.edu.ifsp.pw3.oficina.models.Mecanico;
import br.edu.ifsp.pw3.oficina.models.Veiculo;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoRecordDTO(

        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido. Use o formato xx/xx/xxxx")
        String data_entrada,

        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato de data inválido. Use o formato xx/xx/xxxx")
        String data_saida,

        @NotNull
        @Valid
        MecanicoRecordDTO mecanico,

        @NotNull
        @Valid
        VeiculoRecordDTO veiculo) {
}
