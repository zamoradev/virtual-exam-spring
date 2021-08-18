package com.springboot.virtualexam.exam.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.course.data.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "examen")
@NoArgsConstructor
@AllArgsConstructor
public class ExamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String description;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "fecha_limite", nullable = false)
    private LocalDateTime deadline;

    @Column(name = "activo", nullable = false)
    private boolean enabled;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private CourseEntity course;

    private static final long serialVersionUID = 1L;
}
