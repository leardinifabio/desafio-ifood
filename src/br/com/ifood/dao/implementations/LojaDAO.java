package br.com.ifood.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ifood.dao.DAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.models.Categoria;
import br.com.ifood.models.Loja;
import br.com.ifood.singleton.ConnectionFactory;


public class LojaDAO implements DAO<Loja> {
    	
    @Override
    public Optional<Loja> get(int id) {
    	Loja loja = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   loja.id_loja,"
    			+ "    loja.nr_cnpj,"
    			+ "    loja.nm_razao_social,"
    			+ "    loja.nm_loja,"
    			+ "    loja.nr_telefone,"
    			+ "    loja.ds_email,"
    			+ "    loja.cd_plano,"
    			+ "    categoria.id_categoria,"
    			+ "    categoria.nm_categoria "
    			+ "FROM loja"
    			+ "    INNER JOIN categoria ON loja.id_categoria_loja = categoria.id_categoria "
    			+ "WHERE loja.id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Categoria categoria = new Categoria(
    					result.getInt("id_categoria"),
    					result.getString("nm_categoria")
					);
    			
    			loja = new Loja(
    					result.getInt("id_loja"),
    					result.getString("nr_cnpj"), 
    					result.getString("nm_razao_social"), 
    					result.getString("nm_loja"),
    					result.getString("nr_telefone"),
    					result.getString("ds_email"),
    					result.getString("cd_plano"),
    					categoria
					);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
	    		e.printStackTrace();
			}
    	}
    	
        return Optional.ofNullable(loja);
    }
    
    @Override
    public List<Loja> getAll() {
    	List<Loja> lojas = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   loja.id_loja,"
    			+ "    loja.nr_cnpj,"
    			+ "    loja.nm_razao_social,"
    			+ "    loja.nm_loja,"
    			+ "    loja.nr_telefone,"
    			+ "    loja.ds_email,"
    			+ "    loja.cd_plano,"
    			+ "    categoria.id_categoria,"
    			+ "    categoria.nm_categoria "
    			+ "FROM loja"
    			+ "    INNER JOIN categoria ON loja.id_categoria_loja = categoria.id_categoria";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Categoria categoria = new Categoria(
    					result.getInt("id_categoria"),
    					result.getString("nm_categoria")
					);
    			
    			Loja loja = new Loja(
    					result.getInt("id_loja"),
    					result.getString("nr_cnpj"), 
    					result.getString("nm_razao_social"), 
    					result.getString("nm_loja"),
    					result.getString("nr_telefone"),
    					result.getString("ds_email"),
    					result.getString("cd_plano"),
    					categoria
					);
    			lojas.add(loja);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
	    		e.printStackTrace();
			}
    	}
    	
        return lojas;
    }
    
    @Override
    public void save(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO loja (nr_cnpj, nm_razao_social, nm_loja, nr_telefone, ds_email, cd_plano, id_categoria_loja)"
    			+ "    VALUES (?, ?, ?, ?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, loja.getNr_cnpj());
    		preparedStatement.setString(2, loja.getNm_razao_social());
    		preparedStatement.setString(3, loja.getNm_loja());
    		preparedStatement.setString(4, loja.getNr_telefone());
    		preparedStatement.setString(5, loja.getDs_email());
    		preparedStatement.setString(6, loja.getCd_plano());
    		preparedStatement.setInt(7, loja.getCategoria_loja().getId_categoria());
    		
    		preparedStatement.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    @Override
    public void update(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE loja SET nm_loja = ? WHERE id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, loja.getNm_loja());
    		preparedStatement.setInt(2, loja.getId_loja());
    		
    		preparedStatement.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    @Override
    public void remove(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM loja WHERE id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, loja.getId_loja());
    		preparedStatement.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }

}
