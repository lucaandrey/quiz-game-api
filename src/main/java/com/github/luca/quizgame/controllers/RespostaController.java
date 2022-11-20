package com.github.luca.quizgame.controllers;

import com.github.luca.quizgame.model.Resposta;
import com.github.luca.quizgame.services.RespostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/quizResp")
@RequiredArgsConstructor
public class RespostaController {

    private final RespostaService service;

    @PostMapping
    public ResponseEntity<Resposta> postResps(@RequestBody Resposta resposta){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(resposta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
       Optional<Resposta> respostaOptional = service.findById(id);
       if (!respostaOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resposta nao encontrada");
       }
       service.delete(respostaOptional.get());
       return ResponseEntity.status(HttpStatus.OK).body("Resposta deletada com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRespById(@PathVariable(value = "id") Long id){
        Optional<Resposta> repostaOptional = service.findById(id);
        if (!repostaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resposta nao encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(repostaOptional.get());
    }

    @GetMapping
    public ResponseEntity<Page<Resposta>> getFourResps(@PageableDefault(page = 0, size = 4, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }
}
