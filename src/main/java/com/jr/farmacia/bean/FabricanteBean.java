package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;
import com.jr.farmacia.dao.FabricanteDAO;
import com.jr.farmacia.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;

	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			// FabricanteDAO fabricanteDAO = new FabricanteDAO();
			// fabricantes = fabricanteDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente
					.target("http://localhost:8080/Farmacia/rest/fabricante");
			String json = caminho.request().get(String.class);

			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);

			fabricantes = Arrays.asList(vetor);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			// FabricanteDAO fabricanteDAO = new FabricanteDAO();
			// fabricanteDAO.salvar(fabricante);
			//
			// novo();
			// // atualizo a lista
			// fabricantes = fabricanteDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente
					.target("http://localhost:8080/Farmacia/rest/fabricante");

			Gson gson = new Gson();
			String json = gson.toJson(fabricante);

			caminho.request().post(Entity.json(json));

			fabricante = new Fabricante();

			json = caminho.request().get(String.class);

			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);

			fabricantes = Arrays.asList(vetor);

			Messages.addGlobalInfo("Fabricante salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			fabricante = (Fabricante) evento.getComponent().getAttributes()
					.get("frabricanteSelecionado");
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricante);
			fabricantes = fabricanteDAO.listar();
			Messages.addGlobalInfo("Fabricante removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir um fabricante!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes()
				.get("frabricanteSelecionado");
	}

}
