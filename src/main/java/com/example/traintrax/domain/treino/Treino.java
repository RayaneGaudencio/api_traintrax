package com.example.traintrax.domain.treino;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "treino")
@Entity(name = "Treino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String diaSemana;

    public Treino(String nome, String diaSemana) {
        this.nome = nome;
        this.diaSemana = diaSemana;
    }

    public static Treino treinoEditado(Long id, String nome, String diaSemana) {
        Treino treino = new Treino(id, nome, diaSemana);

        return treino;
    }
}
