package com.springboot.virtualexam.response.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.question.data.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "repuesta")
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String description;

    @Column(name = "repuesta_correcta", nullable = true)
    private boolean correctAnswer;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id")
    private QuestionEntity question;

    private static final long serialVersionUID = 1L;
}
