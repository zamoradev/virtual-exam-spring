package com.springboot.virtualexam.user.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.virtualexam.rol.data.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario", length = 6, unique = true, nullable = false)
    private String username;

    @Column(name = "contrasena", length = 100, nullable = false)
    private String password;

    @Column(name = "activo", nullable = false)
    private boolean enabled;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;

    public UserEntity(String username, String password,  RolEntity rol){
        this.username = username;
        this.password = password;
        this.enabled = true;
        this.rol = rol;
    }

    private static final long serialVersionUID = 1L;
}
