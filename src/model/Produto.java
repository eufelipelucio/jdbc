package model;

import java.util.Objects;

public class Produto {

	private int id;
	private String descricao;
	private Double preco;
	private int estoque;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "id: " + id + " " + "descricao: " + descricao + " " + "preco: " + preco + " " + "estoque: " + estoque;
	}

	public Produto(int id, String descricao, Double preco, int estoque) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}

	public Produto() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, estoque, id, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(estoque, other.estoque)
				&& Objects.equals(id, other.id) && Objects.equals(preco, other.preco);
	}

}
