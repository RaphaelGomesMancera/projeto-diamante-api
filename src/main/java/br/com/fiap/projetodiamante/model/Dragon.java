package br.com.fiap.projetodiamante.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dragons")
public class Dragon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do dragão é obrigatório")
    @Size(max = 100, message = "O nome do dragão deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A cor do dragão é obrigatória")
    @Size(max = 50, message = "A cor do dragão deve ter no máximo 50 caracteres")
    @Column(nullable = false, length = 50)
    private String cor;

    @NotNull(message = "O poder de fogo é obrigatório")
    @PositiveOrZero(message = "O poder de fogo não pode ser negativo")
    @Column(nullable = false)
    private Integer poderDeFogo;

    @NotNull(message = "O peso é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "O peso não pode ser negativo")
    @Column(nullable = false)
    private Double peso;

    @NotNull(message = "A altura é obrigatória")
    @DecimalMin(value = "0.0", inclusive = true, message = "A altura não pode ser negativa")
    @Column(nullable = false)
    private Double altura;

    @Column(nullable = false)
    private Boolean possuiMontador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reino_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Reino reino;

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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getPoderDeFogo() {
        return poderDeFogo;
    }

    public void setPoderDeFogo(Integer poderDeFogo) {
        this.poderDeFogo = poderDeFogo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Boolean getPossuiMontador() {
        return possuiMontador;
    }

    public void setPossuiMontador(Boolean possuiMontador) {
        this.possuiMontador = possuiMontador;
    }

    public Reino getReino() {
        return reino;
    }

    public void setReino(Reino reino) {
        this.reino = reino;
    }
}
