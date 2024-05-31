package com.example.traintrax.domain.treino;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    Treino findAllById(Long idTreino);
}
