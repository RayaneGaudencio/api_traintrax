package com.example.traintrax.domain.treino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEditarTreino(
        @NotNull
        Long id,
        String nome,
        String diaSemana
){
}
