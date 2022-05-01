package br.inatel.sd.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class NotaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "notaCompra")
    private List<NotaCompraItem> listaNotaCompraItem;

    @NotNull
    @ManyToOne // it will be a foreign key
    private Fornecedor fornecedor;

    @NotNull
    private LocalDate dataEmissao;

    public NotaCompra() {
    }

    public NotaCompra(LocalDate dataEmissao, Fornecedor fornecedor) {
        this.dataEmissao = dataEmissao;
        this.fornecedor = fornecedor;
    }


    public BigDecimal getCalculoTotalNota() {
        return listaNotaCompraItem.stream()
                .map(NotaCompraItem::getCalculoTotalItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NotaCompraItem> getListaNotaCompraItem() {
        return this.listaNotaCompraItem;
    }

    public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
        this.listaNotaCompraItem = listaNotaCompraItem;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NotaCompra)) {
            return false;
        }
        NotaCompra notaCompra = (NotaCompra) o;
        return Objects.equals(id, notaCompra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", dataEmissao='" + getDataEmissao() + "'" +
            "}";
    }

}
