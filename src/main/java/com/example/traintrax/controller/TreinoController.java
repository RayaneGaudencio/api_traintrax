package com.example.traintrax.controller;

import com.example.traintrax.domain.exercicio.Exercicio;
import com.example.traintrax.domain.exercicio.ExercicioRepository;
import com.example.traintrax.domain.treino.*;
import com.example.traintrax.exceptions.NotFoundException;
import com.example.traintrax.exceptions.NotFoundExercicios;
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
    @Autowired
    private ExercicioRepository exercicioRepository;

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

    @GetMapping("/listar_exercicio/{id}")
    @Transactional
    public ResponseEntity listarTreinoPorId(@PathVariable("id") Long id) {
        try {
            TreinoComExerciciosDTO treinoComExerciciosDTO = treinoService.listarTreinoComExercicios(id);
            return ResponseEntity.ok(treinoComExerciciosDTO);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado treino com este ID: " + id);
        } catch (NotFoundExercicios e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foram encontrados Exercícios para este treino: " + id);
        }
    }
}
