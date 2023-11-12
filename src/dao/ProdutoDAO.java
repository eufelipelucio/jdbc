package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {
	private Connection con;

	public String adicionarProduto(Produto produto) {
		String sql = "insert into tb_produtos(descricao,preco,estoque) values (?,?,?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, produto.getDescricao());
			stm.setDouble(2, produto.getPreco());
			stm.setInt(3, produto.getEstoque());

			stm.execute();
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Produto adicionado com sucesso!";
	}

	public ArrayList<Produto> selecionarProdutos() {
		String sql = "select * from tb_produtos";
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		try {

			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Produto produto = new Produto();
				produto.setId(result.getInt("id"));
				produto.setDescricao(result.getString("descricao"));
				produto.setPreco(result.getDouble("preco"));
				produto.setEstoque(result.getInt("estoque"));
				listaProdutos.add(produto);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return listaProdutos;
	}

	public Produto selecionarProduto(int id) {
		String sql = "select descricao,preco,estoque from tb_produtos where id=" + id;
		Produto produto = new Produto();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				if (id == result.getInt(id)) {
					produto.setId(result.getInt("id"));
					produto.setDescricao(result.getString("descricao"));
					produto.setPreco(result.getDouble("preco"));
					produto.setEstoque(result.getInt("estoque"));
				}
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		return produto;

	}

	public String editarProduto(int id) {
		Produto produto = selecionarProduto(id);
		String sql = "update tb_produtos set descricao=? ,preco=?,estoque=? where id= " + produto.getId();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, produto.getDescricao());
			stm.setDouble(2, produto.getPreco());
			stm.setInt(3, produto.getEstoque());

			stm.execute();
		} catch (SQLException e) {
			return e.getMessage();
		}
		return "Produto	editado com sucesso!";
	}

	public String excluirProduto(int id) {
		String sql = "delete * from tb_produto where id=" + id;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			e.getMessage();
		}
		return "Produto excluído com sucesso!";
	}

	public ProdutoDAO(Connection conexao) {
		this.setCon(conexao);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
