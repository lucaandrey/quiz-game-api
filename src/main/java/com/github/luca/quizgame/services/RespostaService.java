package com.github.luca.quizgame.services;

import com.github.luca.quizgame.model.Resposta;
import com.github.luca.quizgame.repositories.RespostaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RespostaService {
    private final RespostaRepository repository;
    @Transactional
    public Resposta save(Resposta resposta){
        return repository.save(resposta);
    }
    @Transactional
    public void delete(Resposta resposta){
        repository.delete(resposta);
    }
    public Optional<Resposta> findById(Long id) {
        return repository.findById(id);
    }

    public Page<Resposta> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
