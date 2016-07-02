package com.jr.farmacia.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jr.farmacia.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Sandoz");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 5L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println("Codigo: " + fabricante.getCodigo()
					+ "\nFabricante: " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 4L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null) {
			System.out.println("Registro não encontrado");
		} else {
			fabricanteDAO.excluir(fabricante);
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null) {
			System.out.println("Registro não encontrado");
		} else {
			fabricante.setDescricao("testando1");
			fabricanteDAO.editar(fabricante);
		}
	}
	@Test
	@Ignore
	public void merge() {
		//salvar
		//Fabricante fabricante = new Fabricante();
		//fabricante.setDescricao("Fabricante A");
		//FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//fabricanteDAO.merge(fabricante);
		
		//editar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(5L);
		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);
	}

}
