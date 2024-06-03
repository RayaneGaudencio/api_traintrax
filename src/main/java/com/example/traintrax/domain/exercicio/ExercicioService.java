package com.example.traintrax.domain.exercicio;


import com.example.traintrax.exceptions.NotFoundException;
import com.example.traintrax.domain.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    public DadosExercicio cadastrarExercicio(DadosCadastroExercicio dados) throws NotFoundException {
        var treino = treinoRepository.findAllById(dados.idTreino());

        if (treino == null) {
           throw new NotFoundException("ID Treino não encontrado: " + dados.idTreino());
        }

        Exercicio exercicio = new Exercicio(dados.nome(), dados.series(), dados.repeticoes(), treino);
        exercicioRepository.save(exercicio);

        DadosExercicio dadosExercicio = new DadosExercicio(exercicio);
        return dadosExercicio;
    }

    public DadosExercicio editarExercicio(DadosEditarExercicio dados) {
        Optional<Exercicio> exercicioToUpdate = exercicioRepository.findById(dados.id());

        Exercicio exercicio = exercicioToUpdate.orElse(null);
        if (exercicio == null) {
            throw new NotFoundException("ID do exercício não cadastrado no banco de dados: " + dados.id());
        }

        exercicio.setNome(dados.nome());
        exercicio.setSeries(dados.series());
        exercicio.setRepeticoes(dados.repeticoes());
        exercicioRepository.save(exercicio);

        DadosExercicio dadosExercicio = new DadosExercicio(exercicioToUpdate.orElse(null));
        return dadosExercicio;
    }
}
