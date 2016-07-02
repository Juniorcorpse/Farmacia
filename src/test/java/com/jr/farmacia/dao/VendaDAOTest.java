package com.jr.farmacia.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Cliente;
import com.jr.farmacia.domain.Funcionario;
import com.jr.farmacia.domain.Venda;

public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigoFun = 1L;
		Long codigoCli = 1L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFun);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCli);
		
		Venda venda = new Venda();
		venda.setHorario(new Date());
		venda.setFuncionario(funcionario);
		venda.setCliente(cliente);
		venda.setPrecoTotal(new BigDecimal("222.22"));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);
		
		
	}
	
	@Test
	@Ignore
	public void listar(){
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();
		for(Venda venda : resultado){
			System.out.println(venda);
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		System.out.println(venda);
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		vendaDAO.excluir(venda);
		
	}
	
	@Test	
	public void editar(){
		Long codigo = 1L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		
		venda.setHorario(new Date());
		venda.setPrecoTotal(new BigDecimal("333.22"));
		
		vendaDAO.editar(venda);
		
	}

}
