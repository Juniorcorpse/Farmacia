package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jr.farmacia.dao.EstadoDAO;
import com.jr.farmacia.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		// String texto = "Programação Java Web";
		// FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
		// texto, texto);
		// // Capituraar o cotexto do jsf
		// FacesContext contexto = FacesContext.getCurrentInstance();
		// // Adicionar a mensagem
		// contexto.addMessage(null, mensagem);
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			novo();// pra limpar os campos atualizando o form na visao
			// atualizo a lista
			estados = estadoDAO.listar();
			// usando o OmniFaces
			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes()
					.get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir um estado!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes()
				.get("estadoSelecionado");
	}

}
