package br.com.zupacademy.eduardoalbuquerque.casadocodigo.autor;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.validator.Groups;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
public class Autor {

    @NotNull(groups = Groups.Autor.class)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)//, unique = true)
    private String email;

    @Column(nullable = false, length = 400)
    private String descricao;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();


    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.setEmail(email);
        this.descricao = descricao;
    }

    public Autor() {
    }

    //garante a entrada de dados em  minúsculo
    public void setEmail(String email) {
        this.email = email.toLowerCase(Locale.ROOT);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
