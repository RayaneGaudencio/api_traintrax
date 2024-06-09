package com.example.traintrax.domain.treino;

public record DadosTreino(
        Long id,
        String nome,
        String diaSemana
) {
    public DadosTreino(Treino treino) {
        this(treino.getId(), treino.getNome(), treino.getDiaSemana());
    }
}
