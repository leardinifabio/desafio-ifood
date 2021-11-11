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
import br.com.ifood.models.CategoriaItem;
import br.com.ifood.singleton.ConnectionFactory;

public class CategoriaItemDAO implements DAO<CategoriaItem> {
    	
    @Override
    public Optional<CategoriaItem> get(int id) {
    	CategoriaItem categoriaItem = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   id_categoria_item,"
    			+ "    nm_categoria_item "
    			+ "FROM categoria_item "
    			+ "WHERE id_categoria_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			categoriaItem = new CategoriaItem(
    					result.getInt("id_categoria_item"),
    					result.getString("nm_categoria_item")
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
    	
        return Optional.ofNullable(categoriaItem);
    }
    
    @Override
    public List<CategoriaItem> getAll() {
    	List<CategoriaItem> categoriaItens = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   id_categoria_item,"
    			+ "    nm_categoria_item "
    			+ "FROM categoria_item";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			CategoriaItem categoriaItem = new CategoriaItem(
    					result.getInt("id_categoria_item"),
    					result.getString("nm_categoria_item")
					);
    			categoriaItens.add(categoriaItem);
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
    	
        return categoriaItens;
    }
    
    @Override
    public Optional<CategoriaItem> save(CategoriaItem categoriaItem) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO categoria_item (nm_categoria_item) VALUES (?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, categoriaItem.getNm_categoria_item());
    		
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
    	
    	return Optional.ofNullable(categoriaItem);
    }
    
    @Override
    public void update(CategoriaItem categoriaItem) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE categoria_item SET nm_categoria_item = ? WHERE id_categoria_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, categoriaItem.getNm_categoria_item());
    		preparedStatement.setInt(2, categoriaItem.getId_categoria_item());
    		
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
    public void remove(CategoriaItem categoriaItem) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM categoria_item WHERE id_categoria_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, categoriaItem.getId_categoria_item());
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
