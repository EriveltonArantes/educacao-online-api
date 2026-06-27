package com.educacaoonlineapi.dto;

import jakarta.validation.constraints.*;

public class InstrutorRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "especialidade não pode estar em branco")
    private String especialidade;
    @NotBlank(message = "bio não pode estar em branco")
    private String bio;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
}
