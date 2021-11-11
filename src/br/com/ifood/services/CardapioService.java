package br.com.ifood.services;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import br.com.ifood.converter.ItemConverter;
import br.com.ifood.dao.implementations.CategoriaItemDAO;
import br.com.ifood.dao.implementations.ItemDAO;
import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.CategoriaItem;
import br.com.ifood.models.Item;
import br.com.ifood.models.Loja;

public class CardapioService {
	
	private ItemDAO itemDAO;
	private LojaDAO lojaDAO;
	private CategoriaItemDAO categoriaItemDAO;
	private Locale brazil = new Locale("pt", "BR");

	public CardapioService() {
		itemDAO = DAOFactory.getItemDAO();
		lojaDAO = DAOFactory.getLojaDAO();
		categoriaItemDAO = DAOFactory.getCategoriaItemDAO();
	}
	
	public ItemConverter get(int id) {
		Optional<Item> itemOptional = itemDAO.get(id);
		Item item = itemOptional.get();
		
		Optional<CategoriaItem> categoriaItem = categoriaItemDAO.get(item.getId_categoria_item_item());
		Optional<Loja> loja = lojaDAO.get(item.getId_loja_item());
		
		ItemConverter lojaConverter = new ItemConverter(
				item.getId_item(),
				item.getNm_item(),
				item.getDs_item(),
				item.getVl_preco(),
				loja.get(),
				categoriaItem.get()
			);
		
		return lojaConverter;
	}
	
	public List<ItemConverter> getAll(int lojaId) {
		List<Item> itens = itemDAO.getAllByLojaId(lojaId);
		List<ItemConverter> itensConverter = new ArrayList<>();
		
		for (Item item: itens) {
			Optional<CategoriaItem> categoriaItem = categoriaItemDAO.get(item.getId_categoria_item_item());
			Optional<Loja> loja = lojaDAO.get(item.getId_loja_item());

			itensConverter.add(new ItemConverter(
					item.getId_item(),
					item.getNm_item(),
					item.getDs_item(),
					item.getVl_preco(),
					loja.get(),
					categoriaItem.get()
				));
		}
		
		return itensConverter;
	}
	
	public void save(HttpServletRequest request) throws DBException, ParseException {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(brazil));  
		double preco = (double) df.parseObject(request.getParameter("vl_preco").toString());
		
		Item item = new Item();
		item.setNm_item(request.getParameter("nm_item").toString());
		item.setDs_item(request.getParameter("ds_item").toString());
		item.setVl_preco(preco);
		item.setId_loja_item(Integer.parseInt(request.getParameter("loja_id").toString()));
		item.setId_categoria_item_item(Integer.parseInt(request.getParameter("item_categoria").toString()));
		itemDAO.save(item);
	}
	
	public void update(HttpServletRequest request) throws DBException, ParseException {
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(brazil));  
		double preco = (double) df.parseObject(request.getParameter("vl_preco").toString());

		Item item = new Item();
		item.setId_item(Integer.parseInt(request.getParameter("id_item").toString()));
		item.setNm_item(request.getParameter("nm_item").toString());
		item.setDs_item(request.getParameter("ds_item").toString());
		item.setVl_preco(preco);
		item.setId_loja_item(Integer.parseInt(request.getParameter("loja_id").toString()));
		item.setId_categoria_item_item(Integer.parseInt(request.getParameter("item_categoria").toString()));
		itemDAO.update(item);
	}
	
	public void remove(int id) throws DBException {
		Optional<Item> item = itemDAO.get(id);
		itemDAO.remove(item.get());
	}
	
}
