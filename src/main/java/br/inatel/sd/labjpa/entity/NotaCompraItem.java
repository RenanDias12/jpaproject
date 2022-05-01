package br.inatel.sd.labjpa.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class NotaCompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private NotaCompra notaCompra;

    @NotNull
    @ManyToOne
    private Produto produto;

    @NotNull
    @Positive
    private BigDecimal valorCompraProduto;

    @NotNull
    @Positive
    private Integer quantidade;

    public NotaCompraItem() {
    }

    public NotaCompraItem(NotaCompra notaCompra, Produto produto, BigDecimal valorCompraProduto, int quantidade) {
        this.notaCompra = notaCompra;
        this.produto = produto;
        this.valorCompraProduto = valorCompraProduto;
        this.quantidade = quantidade;
    }

    public BigDecimal getCalculoTotalItem() {
        return valorCompraProduto.multiply(new BigDecimal(this.quantidade));
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotaCompra getNotaCompra() {
        return this.notaCompra;
    }

    public void setNotaCompra(NotaCompra notaCompra) {
        this.notaCompra = notaCompra;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorCompraProduto() {
        return this.valorCompraProduto;
    }

    public void setValorCompraProduto(BigDecimal valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NotaCompraItem)) {
            return false;
        }
        NotaCompraItem notaCompraItem = (NotaCompraItem) o;
        return Objects.equals(id, notaCompraItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", valorCompraProduto='" + getValorCompraProduto() + "'" +
                ", quantidade='" + getQuantidade() + "'" +
                "}";
    }

}
