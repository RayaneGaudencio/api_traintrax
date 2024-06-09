package com.example.traintrax.domain.exercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    Optional<Exercicio> findById(Long id);

    List<Exercicio> findByTreinoId(Long treinoId);

    void deleteByTreinoId(Long treinoId);
}
