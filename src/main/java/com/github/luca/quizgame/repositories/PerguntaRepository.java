package com.github.luca.quizgame.repositories;

import com.github.luca.quizgame.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
