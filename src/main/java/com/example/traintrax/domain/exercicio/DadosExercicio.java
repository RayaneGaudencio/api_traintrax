package com.example.traintrax.domain.exercicio;

public record DadosExercicio(
        Long id,
        String nome,
        String series,
        String repeticoes
) {
    public DadosExercicio(Exercicio exercicio) {
        this(exercicio.getId(), exercicio.getNome(), exercicio.getRepeticoes(), exercicio.getSeries());
    }
}
