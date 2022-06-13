package br.com.alura.jdbc.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection con = factory.conecta();
		
		PreparedStatement stat = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stat.setInt(1, 5);
		stat.execute();
		
		Integer linhasModificadas = stat.getUpdateCount();
		System.out.println("Numero de linhas modificadas " + linhasModificadas);
		
		con.close();
	}

}
