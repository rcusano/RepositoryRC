package com.sopra.phone_shop.dao.impl;

import com.sopra.phone_shop.dao.CountryDAO;
import com.sopra.phone_shop.model.CountryModel;


import javax.sql.DataSource;
import java.sql.*;

public class JdbcCountryDAO implements CountryDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(CountryModel country) throws SQLException {

		String sql = "INSERT INTO COUNTRY " +
				"(  COD, NOME) VALUES ( ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new String[]{"COD"});
			ps.setString(1, country.getCountryCod());
			ps.setString(2, country.getNome());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {

				System.out.println(country.getNome() +" is already on DB");

			} else {
				throw new RuntimeException(e);
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
		@Override
		public CountryModel findCountryByCod (String CountryCod){
			String sql = "SELECT * FROM COUNTRY where cod = ?";

			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,CountryCod);
				CountryModel country = null;
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					country = new CountryModel(
							rs.getString("COD"),
							rs.getString("NOME")
					);
				}
				rs.close();
				ps.close();
				return country;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
					}
				}
			}
		}
	}






