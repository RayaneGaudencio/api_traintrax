package com.example.traintrax.domain.treino;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "treino")
@Entity(name = "Treino")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String diaSemana;

    public Treino(String nome, String diaSemana) {
        this.nome = nome;
        this.diaSemana = diaSemana;
    }
}
