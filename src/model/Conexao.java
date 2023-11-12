package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao = null;
	private static String url;
	private static String user;
	private static String password;
	
	
	public Conexao(String url,String user, String password) {
		this.setUrl(url);
		this.setUser(user);
		this.setPassword(password);
		
	}
	public Conexao() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Connection getConexao() {
		try {
			if (conexao == null) {
				conexao = DriverManager.getConnection(url,user,password);
				System.out.println("Connectou");
			}
			return conexao;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

