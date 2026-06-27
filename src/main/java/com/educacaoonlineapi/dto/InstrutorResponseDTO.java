package com.educacaoonlineapi.dto;

public class InstrutorResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;
    private String bio;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
