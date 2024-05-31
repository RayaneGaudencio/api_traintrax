package com.example.traintrax.domain.exercicio;


import com.example.traintrax.domain.treino.Treino;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "exercicio")
@Entity(name = "Exercicio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    String nome;

    @NotBlank
    String series;

    @NotBlank
    String repeticoes;

    @OneToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    public Exercicio(String nome, String series, String repeticoes, Treino treino) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.treino = treino;
    }
}
