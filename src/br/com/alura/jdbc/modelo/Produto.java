package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Integer categoriaId;

	public Produto(Integer id, String nome, String descricao, Integer categoriaId) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public Produto(String nome, String descricao, Integer categoriaId) {
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	@Override
	public String toString() {
		// return "[Id: " + this.id + ", Nome: " + this.nome + ", Descricão: " +
		// this.descricao + "]";
		return String.format("[Id: %d, nome: %s, descricão: %s, categoria_id: %d]", this.id, this.nome, this.descricao, this.categoriaId);
	}
}
