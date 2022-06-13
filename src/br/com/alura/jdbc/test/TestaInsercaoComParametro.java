package br.com.alura.jdbc.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection con = factory.conecta()) {
			con.setAutoCommit(false);

			try (PreparedStatement stat = con.prepareStatement("INSERT INTO produto(nome,  descricao) VALUES (?,?);",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionaVariavel("Console", "Nintendo Switch", stat);
				adicionaVariavel("Notebook", "Asus VivoBook", stat);
				con.commit();
				stat.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
				System.out.println("Rollback executado");
			}
		}
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stat) throws SQLException {
		stat.setString(1, nome);
		stat.setString(2, descricao);

//		if (nome.equals("Notebook")) {
//			throw new IllegalArgumentException("Notebooks não podem ser inseridos PORRA");
//		}

		stat.execute();

		try (ResultSet result = stat.getGeneratedKeys()) {
			while (result.next()) {
				Integer id = result.getInt(1);
				System.out.println("O Id gerado foi: " + id);
			}
		}
	}

}
