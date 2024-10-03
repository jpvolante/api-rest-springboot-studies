package br.ifsp.edu.pw3.api.conserto;

import br.ifsp.edu.pw3.api.mecanico.DadosCadastroMecanico;
import br.ifsp.edu.pw3.api.mecanico.Mecanico;
import br.ifsp.edu.pw3.api.veiculo.DadosCadastroVeiculo;
import br.ifsp.edu.pw3.api.veiculo.Veiculo;

public record DadosCadastroConserto(String dataEntrada, String dataSaida, DadosCadastroMecanico mecanico, DadosCadastroVeiculo veiculo) {
}
