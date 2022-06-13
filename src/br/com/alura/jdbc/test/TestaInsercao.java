package br.com.alura.jdbc.test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.conecta();

		Statement stat = con.createStatement();
		String nome = "Mouse";
		String descricao = "Mouse sem fio";
		stat.execute("INSERT INTO produto(nome,  descricao) VALUES ('" + nome + "', '" + descricao + "');",
				Statement.RETURN_GENERATED_KEYS);
		ResultSet result = stat.getGeneratedKeys();
		while (result.next()) {
			Integer id = result.getInt(1);
			System.out.println("O Id gerado foi: " + id);
		}

		con.close();
//		stat.execute("UPDATE produto SET nome = 'Geladeira', descricao = 'Geladeira Azul' WHERE id = 2;");

	}
}
