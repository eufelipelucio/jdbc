package controller;


import java.util.ArrayList;

import dao.ProdutoDAO;
import model.Conexao;
import model.Produto;

public class ProdutoController {
	Conexao con = new Conexao("jdbc:mysql://localhost:3306/felipe","user","1234");
	ProdutoDAO produtoDAO = new ProdutoDAO(con.getConexao());
	
	//@PostMapping("/cadastro")
	public String adicionarProduto(/*@ResquestBody */Produto produto) {
		return produtoDAO.adicionarProduto(produto); 
	}
	//@PutMapping("/editar/{id}")
	public String alterarProduto(/*@PathVarieble*/ int id) {
		return produtoDAO.editarProduto(id);
	}
	//@PostMapping("/excluir/{id}")Dielli
	public String excluirProduto(/*@PathVarieble*/int id) {
		return produtoDAO.excluirProduto(id);		
	}
	//@GetMapping("/produtos")
	public ArrayList<Produto> selecionarTodos(){
		return produtoDAO.selecionarProdutos();
	}
	//@GetMapping("/produtos/{id}") Dielli
	public Produto selecionarProduto(/*@PathVarieble*/int id) {
		return produtoDAO.selecionarProduto(id);
	}
}
