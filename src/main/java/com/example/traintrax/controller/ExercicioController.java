package com.example.traintrax.controller;

import com.example.traintrax.domain.exercicio.*;
import com.example.traintrax.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroExercicio dados) {
        try {
            DadosExercicio exercicio = exercicioService.cadastrarExercicio(dados);
            return ResponseEntity.ok(exercicio);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o exercício.");
        }
    }

    @PostMapping("/editar")
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosEditarExercicio dados) {
        try {
            DadosExercicio exercicio = exercicioService.editarExercicio(dados);
            return ResponseEntity.ok(exercicio);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao editar o exercício.");
        }
    }
}
