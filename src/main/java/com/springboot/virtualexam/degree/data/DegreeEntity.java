package com.springboot.virtualexam.degree.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "grado")
@NoArgsConstructor
@AllArgsConstructor
public class DegreeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 10, unique = true, nullable = false)
    private String name;

    private static final long serialVersionUID = 1L;
}
