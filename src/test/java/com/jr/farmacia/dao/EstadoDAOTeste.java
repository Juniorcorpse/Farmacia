package com.jr.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Estado;

public class EstadoDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Acre");
		estado.setSigla("AC");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		System.out.println("Total de registros encontrados: "
				+ resultado.size());
		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 7L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla()
					+ " - " + estado.getNome());
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro não encontrado");
		} else {
			estadoDAO.excluir(estado);
		}
		
	}
	
	
	@Test
	public void editar(){
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Registro não encontrado");
		} else {
			estado.setSigla("MG");
			estadoDAO.editar(estado);
		}
		
	}

}
