package com.example.traintrax.domain.treino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTreino(
        @NotBlank
        String nome,

        @NotBlank
        String diaSemana
) {
}
