package br.com.fiap.projetodiamante.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "reinos")
public class Reino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do reino é obrigatório")
    @Size(max = 100, message = "O nome do reino deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A região é obrigatória")
    @Size(max = 80, message = "A região deve ter no máximo 80 caracteres")
    @Column(nullable = false, length = 80)
    private String regiao;

    @NotNull(message = "A quantidade de castelos é obrigatória")
    @Positive(message = "A quantidade de castelos deve ser maior que zero")
    @Column(nullable = false)
    private Integer quantidadeCastelos;

    @Column(nullable = false)
    private Boolean reinoAliado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getQuantidadeCastelos() {
        return quantidadeCastelos;
    }

    public void setQuantidadeCastelos(Integer quantidadeCastelos) {
        this.quantidadeCastelos = quantidadeCastelos;
    }

    public Boolean getReinoAliado() {
        return reinoAliado;
    }

    public void setReinoAliado(Boolean reinoAliado) {
        this.reinoAliado = reinoAliado;
    }
}
