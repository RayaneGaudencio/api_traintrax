package com.example.traintrax.domain.exercicio;


import com.example.traintrax.domain.treino.TreinoNotFoundException;
import com.example.traintrax.domain.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    public DadosExercicio cadastrarExercicio(DadosCadastroExercicio dados) throws TreinoNotFoundException {
        var treino = treinoRepository.findAllById(dados.idTreino());

        if (treino == null) {
           throw new TreinoNotFoundException("ID Treino não encontrado: " + dados.idTreino());
        }

        Exercicio exercicio = new Exercicio(dados.nome(), dados.series(), dados.repeticoes(), treino);
        exercicioRepository.save(exercicio);

        DadosExercicio dadosExercicio = new DadosExercicio(exercicio);
        return dadosExercicio;
    }
}
