package br.inatel.sd.labjpa.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoUF;


    public String getEnderecoRua() {
        return this.enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoNumero() {
        return this.enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return this.enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return this.enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCidade() {
        return this.enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoUF() {
        return this.enderecoUF;
    }

    public void setEnderecoUF(String enderecoUF) {
        this.enderecoUF = enderecoUF;
    }


    @Override
    public String toString() {
        return "{" +
            " enderecoRua='" + getEnderecoRua() + "'" +
            ", enderecoNumero='" + getEnderecoNumero() + "'" +
            ", enderecoComplemento='" + getEnderecoComplemento() + "'" +
            ", enderecoBairro='" + getEnderecoBairro() + "'" +
            ", enderecoCidade='" + getEnderecoCidade() + "'" +
            ", enderecoUF='" + getEnderecoUF() + "'" +
            "}";
    }
}
