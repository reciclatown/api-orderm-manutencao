package com.reciclatown.controller;

import com.reciclatown.model.OrdemManutencao;
import com.reciclatown.repository.OrdemManutencaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(value = "OrdensManutencao")
public class OrdemManutencaoController {

    @Autowired
    OrdemManutencaoRepository repository;

    @Value("${kafka.bootstrap.servers}")
    String bootstrapServer;

    @ApiOperation(value = "Buscar ordens de manutencao")
    @GetMapping(value = "/ordens_manutencao", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<OrdemManutencao> buscarTodasOrdensManutencaoes() {
        return repository.findAll();
    }

    @ApiOperation(value = "Criar nova ordem de manutencao")
    @PostMapping(value = "/ordens_manutencao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrdemManutencao cadastrarNovaOrdemManutencao(@RequestBody OrdemManutencao ordemManutencao) {
        return repository.save(ordemManutencao);
    }

    @ApiOperation(value = "Buscar informacoes de uma ordem de manutencao")
    @GetMapping(value = "/ordens_manutencao/{id}")
    public Optional<OrdemManutencao> buscarOrdemManutencaoPeloId(@PathVariable String id) {
        return repository.findById(id);
    }

    @ApiOperation(value = "Atualizar dados de uma ordem de manutencao")
    @PutMapping(value = "/ordens_manutencao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizarDadosDaOrdemManutencao(@RequestBody OrdemManutencao ordemManutencao) {
        repository.save(ordemManutencao);
    }

    @ApiOperation(value = "Excluir uma ordem de manutencao")
    @DeleteMapping(value = "/ordens_manutencao/{id}")
    public void excluirOrdemManutencao(@PathVariable String id) {
        OrdemManutencao st = new OrdemManutencao();
        st.setId(id);
        repository.delete(st);
    }

}
