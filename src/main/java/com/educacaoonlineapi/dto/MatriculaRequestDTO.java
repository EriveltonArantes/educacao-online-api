package com.educacaoonlineapi.dto;

import jakarta.validation.constraints.*;

public class MatriculaRequestDTO {

    @NotNull(message = "CursoId é obrigatório")
    @Positive(message = "CursoId deve ser um ID válido (positivo)")
    private Long cursoId;
    @NotBlank(message = "aluno nome não pode estar em branco")
    private String alunoNome;
    @NotBlank(message = "aluno email não pode estar em branco")
    @Email(message = "aluno email precisa ser um e-mail válido")
    private String alunoEmail;
    @NotNull(message = "data matricula não pode ser nulo")
    private java.time.LocalDateTime dataMatricula;
    @NotNull(message = "data vencimento não pode ser nulo")
    private java.time.LocalDateTime dataVencimento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @DecimalMin(value = "0.0", message = "valor pago não pode ser negativo")
    @NotNull(message = "valor pago não pode ser nulo")
    private Double valorPago;

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
