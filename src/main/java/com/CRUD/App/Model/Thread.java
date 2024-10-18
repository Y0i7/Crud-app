package com.CRUD.App.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hilos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "mensaje")
    private String message;
    @Column(name = "fecha_creacion")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Topic publication;



}
