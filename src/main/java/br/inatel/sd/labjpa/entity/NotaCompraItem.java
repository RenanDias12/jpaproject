package br.inatel.sd.labjpa.entity;

import java.math.BigDecimal;

public class NotaCompraItem {
    private Long id;
    private NotaCompra notaCompra;
    private Produto produto;
    private BigDecimal valorCompraProduto;
    private Integer quantidade;
    
}
