package com.educacaoonlineapi.dto;

public class AulaResponseDTO {

    private Long id;
    private Long cursoId;
    private String titulo;
    private String descricao;
    private Integer duracao;
    private Integer ordem;
    private String videoUrl;
    private String material;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
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
