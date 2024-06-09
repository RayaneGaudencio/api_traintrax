package com.example.traintrax.domain.treino;

import com.example.traintrax.domain.exercicio.Exercicio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TreinoComExerciciosDTO(Treino treino, List<Exercicio> exercicios) {

}
