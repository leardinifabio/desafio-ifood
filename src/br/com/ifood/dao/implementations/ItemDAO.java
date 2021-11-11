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
import br.com.ifood.models.Item;
import br.com.ifood.singleton.ConnectionFactory;

public class ItemDAO implements DAO<Item> {
    	
    @Override
    public Optional<Item> get(int id) {
    	Item item = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_item,"
    			+ "    	nm_item,"
    			+ "		ds_item,"
    			+ "		vl_preco,"
    			+ "		id_loja_item,"
    			+ "		id_categoria_item_item "
    			+ "FROM item "
    			+ "WHERE id_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			item = new Item(
    					result.getInt("id_item"),
    					result.getString("nm_item"),
    					result.getString("ds_item"),
    					result.getDouble("vl_preco"),
    					result.getInt("id_loja_item"),
    					result.getInt("id_categoria_item_item")
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
    	
        return Optional.ofNullable(item);
    }
    
    @Override
    public List<Item> getAll() {
    	List<Item> itens = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_item,"
    			+ "    	nm_item,"
    			+ "		ds_item,"
    			+ "		vl_preco,"
    			+ "		id_loja_item,"
    			+ "		id_categoria_item_item "
    			+ "FROM item";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Item item = new Item(
    					result.getInt("id_item"),
    					result.getString("nm_item"),
    					result.getString("ds_item"),
    					result.getDouble("vl_preco"),
    					result.getInt("id_loja_item"),
    					result.getInt("id_categoria_item_item")
					);
    			itens.add(item);
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
    	
        return itens;
    }
    
    public List<Item> getAllByLojaId(int lojaId) {
    	List<Item> itens = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_item,"
    			+ "    	nm_item,"
    			+ "		ds_item,"
    			+ "		vl_preco,"
    			+ "		id_loja_item,"
    			+ "		id_categoria_item_item "
    			+ "FROM item "
    			+ "		WHERE id_loja_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, lojaId);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Item item = new Item(
    					result.getInt("id_item"),
    					result.getString("nm_item"),
    					result.getString("ds_item"),
    					result.getDouble("vl_preco"),
    					result.getInt("id_loja_item"),
    					result.getInt("id_categoria_item_item")
					);
    			itens.add(item);
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
    	
        return itens;
    }
    
    @Override
    public Optional<Item> save(Item item) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO item (nm_item, ds_item, vl_preco, id_loja_item, id_categoria_item_item) "
    			+ "		VALUES (?, ?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, item.getNm_item());
    		preparedStatement.setString(2, item.getDs_item());
    		preparedStatement.setDouble(3, item.getVl_preco());
    		preparedStatement.setInt(4, item.getId_loja_item());
    		preparedStatement.setInt(5, item.getId_categoria_item_item());
    		
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
    	
    	return Optional.ofNullable(item);
    }
    
    @Override
    public void update(Item item) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE item SET nm_item = ?, "
    			+ "		ds_item = ?, "
    			+ "		vl_preco = ?, "
    			+ "		id_loja_item = ?, "
    			+ "		id_categoria_item_item = ? "
    			+ "WHERE id_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, item.getNm_item());
    		preparedStatement.setString(2, item.getDs_item());
    		preparedStatement.setDouble(3, item.getVl_preco());
    		preparedStatement.setInt(4, item.getId_loja_item());
    		preparedStatement.setInt(5, item.getId_categoria_item_item());
    		preparedStatement.setInt(6, item.getId_item());
    		
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
    public void remove(Item item) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM item WHERE id_item = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, item.getId_item());
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
