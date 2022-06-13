package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("R@foca06");
		cpds.setMaxPoolSize(4);
		this.dataSource = cpds;
	}

	public Connection conecta() throws SQLException {
		return this.dataSource.getConnection();

	}
}
