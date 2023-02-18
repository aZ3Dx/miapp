package com.prueba.miapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(nullable = false, length = 70)
    private String nombreUsuario;
    @Column(nullable = false, length = 126)
    private String credencial;

    @ManyToOne
    @JoinColumn(name = "id_rol_fk", referencedColumnName = "id_rol", nullable = false)
    private Rol rol;
}
