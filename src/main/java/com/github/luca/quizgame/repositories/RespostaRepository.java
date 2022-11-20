package com.github.luca.quizgame.repositories;

import com.github.luca.quizgame.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
