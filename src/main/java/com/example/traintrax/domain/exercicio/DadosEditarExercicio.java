package com.example.traintrax.domain.exercicio;

import jakarta.validation.constraints.NotNull;

public record DadosEditarExercicio(
        @NotNull
        Long id,

        String nome,
        String series,
        String repeticoes

) {
}
