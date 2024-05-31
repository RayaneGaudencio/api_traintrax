package com.example.traintrax.domain.exercicio;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroExercicio(

        Long idTreino,

        @NotBlank
        String nome,

        @NotBlank
        String series,

        @NotBlank
        String repeticoes
) {
}
