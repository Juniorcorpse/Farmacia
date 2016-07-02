package com.jr.farmacia.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Funcionario;
import com.jr.farmacia.domain.Pessoa;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigo = 5L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setDataAdmissao(new Date());
		funcionario.setCarteiraTrabalho("892540");
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		for(Funcionario funcionario : resultado){
			System.out.println(funcionario.getDataAdmissao()+"");
			System.out.println(funcionario.getCarteiraTrabalho()+"");
			System.out.println(funcionario.getPessoa()+"");
			System.out.println("*------*------*");
		}
		
		
		
	}
	@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 1L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		System.out.println(funcionario);
		
	}

	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		funcionarioDAO.excluir(funcionario);
		System.out.println(funcionario);
		
	}
	
	@Test
	public void editar(){
		Long codigo = 4L;
		Long codigoPess = 4L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPess);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		funcionario.setDataAdmissao(new Date());
		funcionario.setCarteiraTrabalho("892555");
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.editar(funcionario);
	}
}
