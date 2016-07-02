package com.jr.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Cidade;
import com.jr.farmacia.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		for(Cidade cidade : resultado){
			System.out.println("Cidade: "+cidade.getNome());
			System.out.println("UF: "+cidade.getEstado().getSigla());
			System.out.println("---------------------------");
		}
				
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		System.out.println("Cidade: "+cidade.getNome());
		System.out.println("UF: "+cidade.getEstado().getSigla());
		System.out.println("---------------------------");
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		cidadeDAO.excluir(cidade);
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		Long codestado = 5L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codestado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		System.out.println("Cidade: "+cidade.getNome());
		cidade.setNome("editando3");
		
		cidade.setEstado(estado);
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade: "+cidade.getNome());
		
	}
	// listar as cidades do estado selecionado
	@Test
		public void buscarPorEstado(){
		Long estadoCodigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		for(Cidade cidade : resultado){
			System.out.println("Cidade: "+cidade.getNome());
			System.out.println("UF: "+cidade.getEstado().getSigla());
			System.out.println("---------------------------");
		}
				
	}

}
