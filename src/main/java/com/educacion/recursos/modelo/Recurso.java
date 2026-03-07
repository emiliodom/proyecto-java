package com.educacion.recursos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String subtitulo; // Nuevo campo para el subtítulo
    private String tipo;
    private String url;
    private Boolean disponible;
    private String nombreDocente; // Nuevo campo para el nombre del docente

    // Constructor vacío (obligatorio para JPA)
    public Recurso() {
    }

    // Constructor con parámetros (útil para tests / seed manual)
    public Recurso(String titulo, String subtitulo, String tipo, String url, Boolean disponible, String nombreDocente) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.tipo = tipo;
        this.url = url;
        this.disponible = disponible;
        this.nombreDocente = nombreDocente;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
}
