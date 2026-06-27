package com.educacaoonlineapi.dto;

public class CursoResponseDTO {

    private Long id;
    private Long instrutorId;
    private String titulo;
    private String descricao;
    private Double preco;
    private Integer cargaHoraria;
    private String nivel;
    private Boolean publicado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInstrutorId() { return instrutorId; }
    public void setInstrutorId(Long instrutorId) { this.instrutorId = instrutorId; }
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
