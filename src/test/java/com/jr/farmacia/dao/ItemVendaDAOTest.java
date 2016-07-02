package com.jr.farmacia.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.ItemVenda;
import com.jr.farmacia.domain.Produto;
import com.jr.farmacia.domain.Venda;

public class ItemVendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigoVen = 1L;
		Long codigoProd = 2L;
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVen);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProd);
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);
		itemVenda.setQuantidade(new Short("23"));
		itemVenda.setValorParcial(new BigDecimal("22.22"));
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.salvar(itemVenda);
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemVendaDAO.listar();
		for(ItemVenda itemVenda : resultado){
			System.out.println(itemVenda);
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		System.out.println(itemVenda);
		
	}
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		itemVendaDAO.excluir(itemVenda);
	}
	
	@Test	
	public void editar(){
		Long codigo = 1L;
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		itemVenda.setQuantidade(new Short("20"));
		
		itemVendaDAO.editar(itemVenda);
	}

}
