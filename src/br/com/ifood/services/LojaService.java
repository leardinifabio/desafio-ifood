package br.com.ifood.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import br.com.ifood.converter.LojaConverter;
import br.com.ifood.dao.implementations.CategoriaDAO;
import br.com.ifood.dao.implementations.EnderecoDAO;
import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.dao.implementations.ResponsavelDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.Categoria;
import br.com.ifood.models.Endereco;
import br.com.ifood.models.Loja;
import br.com.ifood.models.Responsavel;

public class LojaService {
	
	private LojaDAO lojaDAO;
	private CategoriaDAO categoriaDAO;
	private EnderecoDAO enderecoDAO;
	private ResponsavelDAO responsavelDAO;

	public LojaService() {
		lojaDAO = DAOFactory.getLojaDAO();
		categoriaDAO = DAOFactory.getCategoriaDAO();
		enderecoDAO = DAOFactory.getEnderecoDAO();
		responsavelDAO = DAOFactory.getResponsavelDAO();
	}
	
	public LojaConverter get(int id) {
		Optional<Loja> lojaOptional = lojaDAO.get(id);
		Loja loja = lojaOptional.get();
		
		Optional<Categoria> categoria = categoriaDAO.get(loja.getId_categoria_loja());
		Optional<Endereco> endereco = enderecoDAO.getByLojaId(loja.getId_loja());
		Optional<Responsavel> responsavel = responsavelDAO.getByLojaId(loja.getId_loja());
		
		LojaConverter lojaConverter = new LojaConverter(
				loja.getId_loja(),
				loja.getNr_cnpj(),
				loja.getNm_razao_social(),
				loja.getNm_loja(),
				loja.getNr_telefone(),
				loja.getDs_email(),
				loja.getCd_plano(),
				categoria.get(),
				endereco.get(),
				responsavel.get()
			);
		
		return lojaConverter;
	}
	
	public List<LojaConverter> getAll() {
		List<Loja> lojas = lojaDAO.getAll();
		List<LojaConverter> lojaConverter = new ArrayList<>();
		
		for (Loja loja: lojas) {
			Optional<Categoria> categoria = categoriaDAO.get(loja.getId_categoria_loja());
			Optional<Endereco> endereco = enderecoDAO.getByLojaId(loja.getId_loja());
			Optional<Responsavel> responsavel = responsavelDAO.getByLojaId(loja.getId_loja());
			
			lojaConverter.add(new LojaConverter(
					loja.getId_loja(),
					loja.getNr_cnpj(),
					loja.getNm_razao_social(),
					loja.getNm_loja(),
					loja.getNr_telefone(),
					loja.getDs_email(),
					loja.getCd_plano(),
					categoria.get(),
					endereco.get(),
					responsavel.get()
				));
		}
		
		return lojaConverter;
	}
	
	public void save(HttpServletRequest request) throws DBException {
		Loja loja = new Loja();
		loja.setNr_cnpj(request.getParameter("nr_cnpj").toString());
		loja.setNm_razao_social(request.getParameter("nm_razao_social").toString());
		loja.setNm_loja(request.getParameter("nm_loja").toString());
		loja.setNr_telefone(request.getParameter("nr_telefone").toString());
		loja.setDs_email(request.getParameter("ds_email").toString());
		loja.setCd_plano("1");
		loja.setId_categoria_loja(Integer.parseInt(request.getParameter("categoria_loja").toString()));
		Optional<Loja> lojaResultset = lojaDAO.save(loja);
				
		Endereco endereco = new Endereco();
		endereco.setNr_cep(request.getParameter("nr_cep").toString());
		endereco.setCd_uf(request.getParameter("cd_uf").toString());
		endereco.setNm_cidade(request.getParameter("nm_cidade").toString());
		endereco.setNm_bairro(request.getParameter("nm_bairro").toString());
		endereco.setNm_endereco(request.getParameter("nm_endereco").toString());
		endereco.setNr_numero(Integer.parseInt(request.getParameter("nr_numero").toString()));
		endereco.setDs_complemento(request.getParameter("ds_complemento").toString());
		endereco.setId_endereco_loja(lojaResultset.get().getId_loja());
		
		@SuppressWarnings("unused")
		Optional<Endereco> enderecoResultset = enderecoDAO.save(endereco);
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNm_responsavel(request.getParameter("nm_responsavel").toString());
		responsavel.setNr_cpf(request.getParameter("nr_cpf").toString());
		responsavel.setNr_rg(request.getParameter("nr_rg").toString());
		responsavel.setId_loja_responsavel(lojaResultset.get().getId_loja());
		
		@SuppressWarnings("unused")
		Optional<Responsavel> responsavelResultset = responsavelDAO.save(responsavel);
	}
	
	public void update(HttpServletRequest request) throws DBException {
		Loja loja = new Loja();
		loja.setId_loja(Integer.parseInt(request.getParameter("id_loja").toString()));
		loja.setNr_cnpj(request.getParameter("nr_cnpj").toString());
		loja.setNm_razao_social(request.getParameter("nm_razao_social").toString());
		loja.setNm_loja(request.getParameter("nm_loja").toString());
		loja.setNr_telefone(request.getParameter("nr_telefone").toString());
		loja.setDs_email(request.getParameter("ds_email").toString());
		loja.setCd_plano("1");
		loja.setId_categoria_loja(Integer.parseInt(request.getParameter("categoria_loja").toString()));
		lojaDAO.update(loja);
				
		Endereco endereco = new Endereco();
		endereco.setId_endereco(Integer.parseInt(request.getParameter("id_endereco").toString()));
		endereco.setNr_cep(request.getParameter("nr_cep").toString());
		endereco.setCd_uf(request.getParameter("cd_uf").toString());
		endereco.setNm_cidade(request.getParameter("nm_cidade").toString());
		endereco.setNm_bairro(request.getParameter("nm_bairro").toString());
		endereco.setNm_endereco(request.getParameter("nm_endereco").toString());
		endereco.setNr_numero(Integer.parseInt(request.getParameter("nr_numero").toString()));
		endereco.setDs_complemento(request.getParameter("ds_complemento").toString());
		endereco.setId_endereco_loja(loja.getId_loja());
		enderecoDAO.update(endereco);
		
		Responsavel responsavel = new Responsavel();
		responsavel.setId_responsavel(Integer.parseInt(request.getParameter("id_responsavel").toString()));
		responsavel.setNm_responsavel(request.getParameter("nm_responsavel").toString());
		responsavel.setNr_cpf(request.getParameter("nr_cpf").toString());
		responsavel.setNr_rg(request.getParameter("nr_rg").toString());
		responsavel.setId_loja_responsavel(loja.getId_loja());
		responsavelDAO.update(responsavel);
	}
	
	public void remove(int id) throws DBException {
		Optional<Loja> loja = lojaDAO.get(id);
		Optional<Endereco> endereco = enderecoDAO.getByLojaId(loja.get().getId_loja());
		Optional<Responsavel> responsavel = responsavelDAO.getByLojaId(loja.get().getId_loja());
		
		enderecoDAO.remove(endereco.get());
		responsavelDAO.remove(responsavel.get());
		lojaDAO.remove(loja.get());
	}
	
}
