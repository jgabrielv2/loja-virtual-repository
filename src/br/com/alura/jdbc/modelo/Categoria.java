package br.com.alura.jdbc.modelo;

public class Categoria {

	private Integer id;
	private String nome;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;

	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {

		return String.format("Id: %d, Categoria: %s", this.id, this.nome);
	}
}
