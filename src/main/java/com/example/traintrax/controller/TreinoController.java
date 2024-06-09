package com.example.traintrax.controller;

import com.example.traintrax.domain.treino.*;
import com.example.traintrax.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTreino dados) {
        var treino = new Treino(dados.nome(), dados.diaSemana());
        treinoRepository.save(treino);

        return ResponseEntity.ok(new DadosTreino(treino));
    }

    @PostMapping("/editar")
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosEditarTreino dados) {
        try {
            DadosTreino dadosTreino = treinoService.editar(dados);
            return ResponseEntity.ok(dadosTreino);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao editar os dados do treino.");
        }
    }

    @GetMapping("/lista")
    @Transactional
    public ResponseEntity listarTreinos() {
        try {
            List<Treino> treinos = treinoRepository.findAll();
            return ResponseEntity.ok(treinos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
