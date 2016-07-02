package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jr.farmacia.dao.CidadeDAO;
import com.jr.farmacia.dao.EstadoDAO;
import com.jr.farmacia.domain.Cidade;
import com.jr.farmacia.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}
	}

	public void novo() {
		try {			
		
		cidade = new Cidade();

		EstadoDAO estadoDAO = new EstadoDAO();
		estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar uma nova cidade!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			cidades = cidadeDAO.listar();

			Messages.addGlobalInfo("Cidade salva com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes()
					.get("cidadeSelecionada");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cidade removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir uma cidade!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar uma nova cidade");
			erro.printStackTrace();
		}
	}

}
