package com.educacaoonlineapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @Column(nullable = false)
    private String titulo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Integer duracao;
    private Integer ordem;
    @Column(nullable = false)
    private String videoUrl;
    @Column(nullable = false)
    private String material;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }
    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
