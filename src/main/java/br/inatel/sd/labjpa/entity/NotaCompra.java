package br.inatel.sd.labjpa.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

public class NotaCompra {
    private Long id;
    private List<NotaCompraItem> listaNotaCompraItem;
    private Fornecedor fornecedor;

    @NotNull
    private LocalDate dataEmissao;
}
