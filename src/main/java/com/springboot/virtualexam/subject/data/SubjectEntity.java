package com.springboot.virtualexam.subject.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "materia")
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 20, unique = true, nullable = false)
    private String name;

    private static final long serialVersionUID = 1L;
}
