package com.jr.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	//@Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("fulano2");
		pessoa.setCpf("123.000.103.30");
		pessoa.setRg("41734202");
		pessoa.setRua("mexico");
		pessoa.setNumero(new Short("2"));
		pessoa.setBairro("Centro");
		pessoa.setCep("3414-1122");
		pessoa.setComplemento("teste2");
		pessoa.setTelefone("3498-1220");
		pessoa.setCelular("9803335");
		pessoa.setEmail("fulano2@teste.com");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		for (Pessoa pessoa : resultado) {
			System.out.println("nome: " + pessoa.getNome());
			System.out.println("nome: " + pessoa.getCpf());
			System.out.println("nome: " + pessoa.getRg());
			System.out.println("nome: " + pessoa.getRua());
			System.out.println("nome: " + pessoa.getNumero());
			System.out.println("nome: " + pessoa.getBairro());
			System.out.println("nome: " + pessoa.getCep());
			System.out.println("nome: " + pessoa.getComplemento());
			System.out.println("nome: " + pessoa.getTelefone());
			System.out.println("nome: " + pessoa.getCelular());
			System.out.println("nome: " + pessoa.getEmail());

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		System.out.println("nome: " + pessoa.getNome());
		System.out.println("nome: " + pessoa.getCpf());
		System.out.println("nome: " + pessoa.getRg());
		System.out.println("nome: " + pessoa.getRua());
		System.out.println("nome: " + pessoa.getNumero());
		System.out.println("nome: " + pessoa.getBairro());
		System.out.println("nome: " + pessoa.getCep());
		System.out.println("nome: " + pessoa.getComplemento());
		System.out.println("nome: " + pessoa.getTelefone());
		System.out.println("nome: " + pessoa.getCelular());
		System.out.println("nome: " + pessoa.getEmail());

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		pessoaDAO.excluir(pessoa);

	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoa.setNome("fulanoeditado");
		pessoa.setRua("Pará");
		
		pessoaDAO.editar(pessoa);
	}

}
