package br.com.zup.edu.cadastrolistaenderecos;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ZupperRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotNull
    private Cargo cargo;

    public ZupperRequest(String nome, String email, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public ZupperRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Zupper toModel(){
        return new Zupper(nome, email, cargo);
    }

}
