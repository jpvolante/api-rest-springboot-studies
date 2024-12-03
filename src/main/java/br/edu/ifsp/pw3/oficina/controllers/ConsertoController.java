package br.edu.ifsp.pw3.oficina.controllers;

import br.edu.ifsp.pw3.oficina.dtos.AtualizacaoConsertoDTO;
import br.edu.ifsp.pw3.oficina.dtos.ConsertoRecordDTO;
import br.edu.ifsp.pw3.oficina.dtos.DetalhamentoConsertoDTO;
import br.edu.ifsp.pw3.oficina.dtos.ListagemConsertoDTO;
import br.edu.ifsp.pw3.oficina.models.Conserto;
import br.edu.ifsp.pw3.oficina.repositories.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @GetMapping
    public Page<ListagemConsertoDTO> listarConsertos(@PageableDefault(
            size = 3,
            page = 0,
            sort = {},
            direction = Sort.Direction.DESC) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemConsertoDTO::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ConsertoRecordDTO dados,
                                    UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoConsertoDTO(conserto));
    }

    @GetMapping("/algunsdados")
    public List<ListagemConsertoDTO> listarAlgunsDados(){
        return repository.findAll().stream().map(ListagemConsertoDTO::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {

        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DetalhamentoConsertoDTO(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoConsertoDTO dados){
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoConsertoDTO(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}
