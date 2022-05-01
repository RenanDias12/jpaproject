package br.inatel.sd.labjpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.sd.labjpa.entity.Fornecedor;
import br.inatel.sd.labjpa.entity.NotaCompra;
import br.inatel.sd.labjpa.entity.NotaCompraItem;
import br.inatel.sd.labjpa.entity.Produto;
import br.inatel.sd.labjpa.service.FornecedorService;
import br.inatel.sd.labjpa.service.NotaCompraService;
import br.inatel.sd.labjpa.service.ProdutoService;

@SpringBootTest
class LabjpaApplicationTests {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private NotaCompraService notaCompraService;

	@Test
	void contextLoads() {

		// 1 Produto
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Serra Circular");
		Produto p3 = new Produto("Lixadeira");
		Produto p4 = new Produto("Plaina");
		Produto p5 = new Produto("Tupia");

		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);

		produtoService.listar().forEach(System.out::println);

		// 2 Fornecedor
		Fornecedor f1 = new Fornecedor("Gasometro Madeiras");
		f1.getEndereco().setEnderecoRua("Avenida Pinto Cobra");
		f1.getEndereco().setEnderecoNumero("110");
		f1.getEndereco().setEnderecoBairro("Vila Mariana");
		f1.getEndereco().setEnderecoCidade("Pouso Alegre");
		f1.getEndereco().setEnderecoUF("MG");

		Fornecedor f2 = new Fornecedor("Loja do Mecanico");
		f2.getEndereco().setEnderecoRua("Av Reinaldo Chioca");
		f2.getEndereco().setEnderecoNumero("1922");
		f2.getEndereco().setEnderecoBairro("Parque Progresso");
		f2.getEndereco().setEnderecoCidade("Franca");
		f2.getEndereco().setEnderecoUF("SP");

		f1 = fornecedorService.salvar(f1);
		f2 = fornecedorService.salvar(f2);

		fornecedorService.listar().forEach(System.out::println);

		// 3 Nota de Compra
		NotaCompra nc1 = new NotaCompra(LocalDate.of(2022, 1, 13), f1);
		nc1 = notaCompraService.salvar(nc1);

		NotaCompraItem i1_1 = new NotaCompraItem(nc1, p3, new BigDecimal("350.00"), 2);
		NotaCompraItem i1_2 = new NotaCompraItem(nc1, p2, new BigDecimal("500.00"), 1);
		NotaCompraItem i1_3 = new NotaCompraItem(nc1, p4, new BigDecimal("1240.00"), 1);
		i1_1 = notaCompraService.salvar(i1_1);
		i1_2 = notaCompraService.salvar(i1_2);
		i1_3 = notaCompraService.salvar(i1_3);

		NotaCompra nc2 = new NotaCompra(LocalDate.of(2022, 2, 25), f1);
		nc2 = notaCompraService.salvar(nc2);

		NotaCompraItem i2_1 = new NotaCompraItem(nc2, p1, new BigDecimal("850.00"), 2);
		NotaCompraItem i2_2 = new NotaCompraItem(nc2, p5, new BigDecimal("300.00"), 1);
		i2_1 = notaCompraService.salvar(i2_1);
		i2_2 = notaCompraService.salvar(i2_2);

		NotaCompra nc3 = new NotaCompra(LocalDate.of(2022, 4, 26), f2);
		nc3 = notaCompraService.salvar(nc3);

		NotaCompraItem i3_1 = new NotaCompraItem(nc3, p1, new BigDecimal("750.00"), 3);
		NotaCompraItem i3_2 = new NotaCompraItem(nc3, p3, new BigDecimal("250.00"), 2);
		i3_1 = notaCompraService.salvar(i3_1);
		i3_2 = notaCompraService.salvar(i3_2);

		notaCompraService.listarNotaCompra().forEach(System.out::println);
		notaCompraService.listarNotaCompraItem().forEach(System.out::println);
	}

}
