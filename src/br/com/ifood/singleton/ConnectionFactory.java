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
	 * M�todo respons�vel por estabelecer conex�o com o banco de dados 
	 * @exception SQLException
	 * @exception ClassNotFoundException
	 * @return Conex�o com o banco de dados
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
	 * M�todo respons�vel por verificar se a conex�o com o banco de dados
	 * est� ativa, caso n�o esteja, cria uma conex�o e retorna a inst�ncia de conex�o
	 * @return Inst�ncia de conex�o com o banco de dados
	 */
	public static Connection getInstance() { 
		if (connection.equals(null)) {
			new ConnectionFactory();
		}
		return connection;
	}
	
	/**
	 * M�todo respons�vel por fechar a conex�o com o banco de dados
	 * @throws SQLException
	 */
	public static void closeConnection() throws SQLException {
		connection.close();
		connection = null;
	}

}
