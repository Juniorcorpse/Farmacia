package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jr.farmacia.dao.ClienteDAO;
import com.jr.farmacia.dao.PessoaDAO;
import com.jr.farmacia.domain.Cliente;
import com.jr.farmacia.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;	
	private List<Pessoa> pessoas;
	
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("dataCadastro");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao listar clientes");
			erro.printStackTrace();

		}

	}
	
	public void novo(){
		try{
		cliente = new Cliente();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo cliente");
			erro.printStackTrace();

		}
		
			
		
	}
	public void salvar(){
		try{
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.merge(cliente);
		
		cliente = new Cliente();
		
		clientes = clienteDAO.listar("dataCadastro");
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoas = pessoaDAO.listar("nome");
		Messages.addGlobalInfo("Cliente salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar criar um novo cliente");
			erro.printStackTrace();

		}
	}
	
	public void excluir(ActionEvent evento){
		try{
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(cliente);
		
		clientes = clienteDAO.listar("dataCadastro");
		
		Messages.addGlobalInfo("Cliente excluido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar excluir um cliente");
			erro.printStackTrace();

		}
	}
	
	public void editar(ActionEvent evento){
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar editar um cliente");
			erro.printStackTrace();

		}
	}
	
	

}
