package br.ifsp.edu.pw3.api.controller;


import br.ifsp.edu.pw3.api.conserto.Conserto;
import br.ifsp.edu.pw3.api.conserto.ConsertoRepository;
import br.ifsp.edu.pw3.api.conserto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConserto dados){
        System.out.println(dados);
        repository.save(new Conserto(dados));
    }
}

