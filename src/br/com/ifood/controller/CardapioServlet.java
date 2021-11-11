package br.com.ifood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.converter.ItemConverter;
import br.com.ifood.dao.implementations.CategoriaItemDAO;
import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.Item;
import br.com.ifood.models.Loja;
import br.com.ifood.services.CardapioService;

public class CardapioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	private CardapioService service;
	private LojaDAO lojaDAO;
	private CategoriaItemDAO categoriaItemDAO;
	private Loja loja;
	
	/* INIT */
	
	public void init() throws ServletException {
		super.init();
		service = new CardapioService();
		lojaDAO = DAOFactory.getLojaDAO();
		categoriaItemDAO = DAOFactory.getCategoriaItemDAO();
	}
	
	/* ACTIONS */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		this.loadLoja(request, response);
		
		if (action == null) {
			this.getAll(request, response);
		} else {
			switch(action.toString()) {
				case "new":
					request.setAttribute("cardapio", new Item());
					request.setAttribute("categorias", categoriaItemDAO.getAll());
					request.setAttribute("loja", loja);
					request.setAttribute("action", "new");
					request.getRequestDispatcher("cardapios/create.jsp").forward(request, response);
					break;
				case "update":
					ItemConverter itemToUpdate = service.get(Integer.parseInt(request.getParameter("id").toString()));
					
					request.setAttribute("item", itemToUpdate);
					request.setAttribute("categorias", categoriaItemDAO.getAll());
					request.setAttribute("loja", loja);
					request.setAttribute("action", "update");
					request.getRequestDispatcher("cardapios/update.jsp").forward(request, response);
					break;
				case "delete":
					try {
						int id = Integer.parseInt(request.getParameter("id").toString());
						service.remove(id);
					} catch (DBException db) {
						request.setAttribute("error", db.getMessage());
						db.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("error", e.getMessage());
					}
					
					this.getAll(request, response);
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.loadLoja(request, response);

		switch(request.getParameter("action").toString()) {
			case "create":
				try {
					service.save(request);
					request.setAttribute("success", "Loja cadastrada com sucesso!");
					this.getAll(request, response);
				} catch (DBException db) {
					request.setAttribute("error", db.getMessage());
					db.printStackTrace();
					request.getRequestDispatcher("cardapios/create.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
					e.printStackTrace();
					request.getRequestDispatcher("cardapios/create.jsp").forward(request, response);
				}
				break;
			case "update":
				try {
					service.update(request);
					request.setAttribute("success", "Loja atualizada com sucesso!");
					this.getAll(request, response);
				} catch (DBException db) {
					request.setAttribute("error", db.getMessage());
					db.printStackTrace();
					request.getRequestDispatcher("cardapios/update.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
					e.printStackTrace();
					request.getRequestDispatcher("cardapios/update.jsp").forward(request, response);
				}
				break;
		}		
	}
	
	/* METHODS */
	
	/**
	 * Método responsavel por realizar chamada de index
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ItemConverter> itens = service.getAll(loja.getId_loja());
			request.setAttribute("cardapio", itens);
			request.setAttribute("loja", loja);
			request.getRequestDispatcher("cardapios/index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsavel por realizar o load da loja
	 * @param request
	 * @param response
	 */
	protected void loadLoja(HttpServletRequest request, HttpServletResponse response) {
		Optional<Loja> lojaOptional = lojaDAO.get(Integer.parseInt(request.getParameter("loja_id").toString()));
		loja = lojaOptional.get();
	}

}
