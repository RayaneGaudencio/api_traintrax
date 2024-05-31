package com.example.traintrax.domain.treino;


import com.example.traintrax.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {

    @Autowired
    TreinoRepository treinoRepository;

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
}
