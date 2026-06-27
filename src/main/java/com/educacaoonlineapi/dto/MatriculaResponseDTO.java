package com.educacaoonlineapi.dto;

public class MatriculaResponseDTO {

    private Long id;
    private Long cursoId;
    private String alunoNome;
    private String alunoEmail;
    private java.time.LocalDateTime dataMatricula;
    private java.time.LocalDateTime dataVencimento;
    private String status;
    private Double valorPago;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }
    public String getAlunoEmail() { return alunoEmail; }
    public void setAlunoEmail(String alunoEmail) { this.alunoEmail = alunoEmail; }
    public java.time.LocalDateTime getDataMatricula() { return dataMatricula; }
    public void setDataMatricula(java.time.LocalDateTime dataMatricula) { this.dataMatricula = dataMatricula; }
    public java.time.LocalDateTime getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(java.time.LocalDateTime dataVencimento) { this.dataVencimento = dataVencimento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getValorPago() { return valorPago; }
    public void setValorPago(Double valorPago) { this.valorPago = valorPago; }
}
