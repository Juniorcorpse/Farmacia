package com.jr.farmacia.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Fabricante;
import com.jr.farmacia.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));

		Produto produto = new Produto();
		produto.setDescricao("Omeprazol2");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		for (Produto produto : resultado) {
			System.out.println("Produto: " + produto.getDescricao()
					+ "\n Fabricante: "
					+ produto.getFabricante().getDescricao());

		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
			System.out.println("Produto: " + produto.getDescricao()
					+ "\n Fabricante: "
					+ produto.getFabricante().getDescricao());

		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		produtoDAO.excluir(produto);
	}
	
	@Test
	public void editar(){
		Long codigo = 2L;
		Long coditoFab = 3L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(coditoFab);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		produto.setDescricao("editando");
		
		produto.setPreco(new BigDecimal("09.70"));
		produto.setQuantidade(new Short("2"));
		
		produto.setFabricante(fabricante);		
		produtoDAO.salvar(produto);
		
	}

}
