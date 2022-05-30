package br.com.zup.edu.cadastrolistaenderecos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {

    @NotBlank
    private String lougradouro;

    @NotNull
    private Integer numero;

    @NotBlank
    private String bairro;

    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String cep;

    public EnderecoRequest(String lougradouro, Integer numero, String bairro, String complemento, String cidade, String estado, String cep) {
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public EnderecoRequest() {
    }

    public Endereco toModel(Zupper zupper) {
        return new Endereco(lougradouro, numero, bairro, complemento, cidade, estado, cep, zupper);
    }

    public String getLougradouro() {
        return lougradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
