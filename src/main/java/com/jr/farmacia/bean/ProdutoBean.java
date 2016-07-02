package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jr.farmacia.dao.FabricanteDAO;
import com.jr.farmacia.dao.ProdutoDAO;
import com.jr.farmacia.domain.Fabricante;
import com.jr.farmacia.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar");
			erro.printStackTrace();

		}

	}

	public void novo() {
		try {
		produto = new Produto();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricantes = fabricanteDAO.listar("descricao");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo produto!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			produto = new Produto();
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
			produtos = produtoDAO.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar salvar!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes()
					.get("produtoSelecionado");
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			produtos = produtoDAO.listar();
			Messages.addGlobalInfo("Produto removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao excluir um produto!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes()
					.get("produtoSelecionado");
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um novo prouduto");
			erro.printStackTrace();
		}
	}

}
