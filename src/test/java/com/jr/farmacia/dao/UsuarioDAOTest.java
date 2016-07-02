package com.jr.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Pessoa;
import com.jr.farmacia.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("1234");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}
	
	@Test
	@Ignore
	public void listar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		for(Usuario usuario : resultado){
			System.out.println(usuario);
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		System.out.println(usuario);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		usuarioDAO.excluir(usuario);

	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 1L;
		Long codigoPess = 4L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPess);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		
		usuario.setAtivo(false);
		usuario.setTipo('X');
		usuario.setPessoa(pessoa);
		
		usuarioDAO.editar(usuario);
	}
		


}
