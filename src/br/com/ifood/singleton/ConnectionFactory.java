package br.com.ifood.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	/* PROPERTIES */
	
	final static String DB_URL = "jdbc:oracle:thin:@localhost:49161:xe";
	final static String DB_USERNAME = "system";
	final static String DB_PASSWORD = "oracle";
	private static Connection connection;
	
	/* CONSTRUCTOR */
	
	private ConnectionFactory() {
		connection = this.getConnection();
	}
	
	/* METHODS */
	
	/**
	 * Método responsável por estabelecer conexão com o banco de dados 
	 * @exception SQLException
	 * @exception ClassNotFoundException
	 * @return Conexão com o banco de dados
	 */
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Properties props = new Properties();
			props.put("user", DB_USERNAME);
			props.put("password", DB_PASSWORD);
			props.put("defaultRowPrefetch", "20");
			
			connection = DriverManager.getConnection(DB_URL, props);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * Método responsável por verificar se a conexão com o banco de dados
	 * está ativa, caso não esteja, cria uma conexão e retorna a instância de conexão
	 * @return Instância de conexão com o banco de dados
	 */
	public static Connection getInstance() { 
		if (connection.equals(null)) {
			new ConnectionFactory();
		}
		return connection;
	}
	
	/**
	 * Método responsável por fechar a conexão com o banco de dados
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		connection.close();
		connection = null;
	}

}
