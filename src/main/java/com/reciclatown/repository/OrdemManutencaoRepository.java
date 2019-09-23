package com.reciclatown.repository;

import com.reciclatown.model.OrdemManutencao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdemManutencaoRepository extends MongoRepository<OrdemManutencao, String> {
}
