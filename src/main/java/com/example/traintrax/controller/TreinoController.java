package com.example.traintrax.controller;

import com.example.traintrax.domain.treino.DadosCadastroTreino;
import com.example.traintrax.domain.treino.DadosTreino;
import com.example.traintrax.domain.treino.Treino;
import com.example.traintrax.domain.treino.TreinoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTreino dados) {
        var treino = new Treino(dados.nome(), dados.diaSemana());
        treinoRepository.save(treino);

        return ResponseEntity.ok(new DadosTreino(treino));
    }
;
}
