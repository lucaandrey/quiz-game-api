package com.github.luca.quizgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pergunta;
    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pergunta")
    private List<Resposta> resposta;
}
