package com.example.ejemplo_examen_autores.model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @Column
    private String titulo;

    @Column
    @Enumerated(EnumType.STRING)
    private GeneroLibro genero;

    @Column
    private Integer anyoPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Libro() {
    }

    public Libro(Integer idLibro, String titulo, GeneroLibro genero, Integer anyoPublicacion, Autor autor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.genero = genero;
        this.anyoPublicacion = anyoPublicacion;
        this.autor = autor;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public GeneroLibro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLibro genero) {
        this.genero = genero;
    }

    public Integer getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(Integer anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
