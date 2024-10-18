package com.CRUD.App.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "publicaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "mensaje", columnDefinition = "TEXT")
    private String message;
    @Column(name = "fecha_creacion")
    private LocalDateTime createdAt;
    @Column(name = "estado")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
