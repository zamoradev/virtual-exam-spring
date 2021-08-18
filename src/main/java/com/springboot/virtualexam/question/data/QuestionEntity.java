package com.springboot.virtualexam.question.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.exam.data.ExamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "preguntas")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String description;

    @Column(name = "puntaje", nullable = false)
    private double score;

    @Column(name = "activo", nullable = false)
    private boolean enabled;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examen_id")
    private ExamEntity exam;

    private static final long serialVersionUID = 1L;
}
