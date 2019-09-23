package com.reciclatown.controller;

import com.reciclatown.model.OrdemManutencao;
import com.reciclatown.repository.OrdemManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrdemManutencaoController {

    @Autowired
    OrdemManutencaoRepository repository;

    @GetMapping(value = "/ordens_manutencao", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<OrdemManutencao> buscarTodasOrdensManutencaoes() {
        return repository.findAll();
    }

    @PostMapping(value = "/ordens_manutencao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrdemManutencao cadastrarNovaOrdemManutencao(@RequestBody OrdemManutencao ordemManutencao) {
        return repository.save(ordemManutencao);
    }

    @GetMapping(value = "/ordens_manutencao/{id}")
    public Optional<OrdemManutencao> buscarOrdemManutencaoPeloId(@PathVariable String id) {
        return repository.findById(id);
    }

    @PutMapping(value = "/ordens_manutencao/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizarDadosDaOrdemManutencao(@RequestBody OrdemManutencao ordemManutencao) {
        repository.save(ordemManutencao);
    }

    @DeleteMapping(value = "/ordens_manutencao/{id}")
    public void excluirOrdemManutencao(@PathVariable String id) {
        OrdemManutencao st = new OrdemManutencao();
        st.setId(id);
        repository.delete(st);
    }

}
