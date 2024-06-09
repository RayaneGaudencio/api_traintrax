package com.example.traintrax.domain.treino;


import com.example.traintrax.domain.exercicio.Exercicio;
import com.example.traintrax.domain.exercicio.ExercicioRepository;
import com.example.traintrax.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    TreinoRepository treinoRepository;
    @Autowired
    private ExercicioRepository exercicioRepository;

    public DadosTreino editar(DadosEditarTreino dados) {
        var treinoCadastrado = treinoRepository.findAllById(dados.id());

        if (treinoCadastrado == null) {
            throw new NotFoundException("ID Treino não encontrado: " + dados.id());
        }

        var treino = Treino.treinoEditado(dados.id(), dados.nome(), dados.diaSemana());
        treinoRepository.save(treino);
        DadosTreino dadosTreino = new DadosTreino(treino);

        return dadosTreino;
    }

    public TreinoComExerciciosDTO listarTreinoComExercicios(Long id) {
        Treino treino = treinoRepository.findAllById(id);
        List<Exercicio> exercicios = exercicioRepository.findByTreinoId(id);

        if (treino == null) {
            throw new NotFoundException("Não foi encontrado treino com este ID: " + id);
        }

        return new TreinoComExerciciosDTO(treino, exercicios);
    }

}
