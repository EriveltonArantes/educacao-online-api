package com.educacaoonlineapi.dto;

import jakarta.validation.constraints.*;

public class AulaRequestDTO {

    @NotNull(message = "CursoId é obrigatório")
    @Positive(message = "CursoId deve ser um ID válido (positivo)")
    private Long cursoId;
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "duracao não pode ser nulo")
    private Integer duracao;
    @NotNull(message = "ordem não pode ser nulo")
    private Integer ordem;
    @NotBlank(message = "video url não pode estar em branco")
    private String videoUrl;
    @NotBlank(message = "material não pode estar em branco")
    private String material;

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
