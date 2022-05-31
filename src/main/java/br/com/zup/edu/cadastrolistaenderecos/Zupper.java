package br.com.zup.edu.cadastrolistaenderecos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zupper {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToMany(mappedBy = "zupper", cascade = {CascadeType.ALL})
    private List<Endereco> endereco;

    public Zupper(String nome, String email, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Zupper() {
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Endereco endereco) {
        this.endereco.add(endereco);
    }
}
