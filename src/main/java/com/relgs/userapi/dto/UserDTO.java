package com.relgs.userapi.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;

public class UserDTO{

    @NotBlank(message = "nome é obrigatorio")
    private String nome;
    @NotBlank(message = "cpf é obrigatorio")
    private String cpf;
    private String endereco;
    @NotBlank(message = "email é obrigatorio")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    
    public UserDTO(String nome, String cpf, String endereco, String email, String telefone,
            LocalDateTime dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
