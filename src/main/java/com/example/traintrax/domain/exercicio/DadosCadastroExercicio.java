package com.example.traintrax.domain.exercicio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroExercicio(
        @NotNull
        Long idTreino,

        @NotBlank
        String nome,

        @NotBlank
        String series,

        @NotBlank
        String repeticoes
) {
}
