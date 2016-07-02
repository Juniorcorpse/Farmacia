package com.jr.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.jr.farmacia.dao.ItemVendaDAO;
import com.jr.farmacia.domain.ItemVenda;
import com.jr.farmacia.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItemVendaBean implements Serializable {
	private ItemVenda itemVenda;
	private List<ItemVenda> itemVendas;
	private List<Venda> vendas;

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	public List<ItemVenda> getItemVendas() {
		return itemVendas;
	}

	public void setItemVendas(List<ItemVenda> itemVendas) {
		this.itemVendas = itemVendas;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	@PostConstruct
	public void listar(){
		try {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendas = itemVendaDAO.listar("valorParcial");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar listar itens da venda");

		}
	}

}
