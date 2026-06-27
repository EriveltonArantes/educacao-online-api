package com.educacaoonlineapi.dto;

import jakarta.validation.constraints.*;

public class CursoRequestDTO {

    @NotNull(message = "InstrutorId é obrigatório")
    @Positive(message = "InstrutorId deve ser um ID válido (positivo)")
    private Long instrutorId;
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "preco não pode ser negativo")
    @NotNull(message = "preco não pode ser nulo")
    private Double preco;
    @NotNull(message = "carga horaria não pode ser nulo")
    private Integer cargaHoraria;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotNull(message = "publicado não pode ser nulo")
    private Boolean publicado;

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
