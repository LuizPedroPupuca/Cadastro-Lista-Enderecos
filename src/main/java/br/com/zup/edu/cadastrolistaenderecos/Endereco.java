package br.com.zup.edu.cadastrolistaenderecos;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lougradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String bairro;

    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cep;

    @ManyToOne(optional = false)
    private Zupper zupper;

    public Endereco(String lougradouro, Integer numero, String bairro, String complemento, String cidade, String estado, String cep, Zupper zupper) {
        this.lougradouro = lougradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.zupper = zupper;
    }

    public Endereco() {
    }

    public Long getId() {
        return id;
    }
}
