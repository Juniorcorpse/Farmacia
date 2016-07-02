package com.jr.farmacia.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Cliente;
import com.jr.farmacia.domain.Pessoa;

public class CienteDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);

		Cliente cliente = new Cliente();
		// cliente.setDataCadastro(new Date());
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy")
				.parse("09/04/2016"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		for (Cliente cliente : resultado) {
			System.out.println(cliente);
		}

	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		System.out.println(cliente);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		clienteDAO.excluir(cliente);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		Long coditoPess = 3L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(coditoPess);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
				
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);
		
		cliente.setPessoa(pessoa);
		
		clienteDAO.editar(cliente);
	}
		

}
