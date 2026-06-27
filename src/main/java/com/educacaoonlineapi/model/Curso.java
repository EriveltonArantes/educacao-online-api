package com.educacaoonlineapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
    @Column(nullable = false)
    private String titulo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Double preco;
    private Integer cargaHoraria;
    @Column(nullable = false)
    private String nivel;
    private Boolean publicado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Instrutor getInstrutor() { return instrutor; }
    public void setInstrutor(Instrutor instrutor) { this.instrutor = instrutor; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public Boolean getPublicado() { return publicado; }
    public void setPublicado(Boolean publicado) { this.publicado = publicado; }
}
