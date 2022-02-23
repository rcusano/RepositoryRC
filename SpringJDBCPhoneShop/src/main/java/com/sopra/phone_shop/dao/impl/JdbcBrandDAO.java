package com.sopra.phone_shop.dao.impl;

import com.sopra.phone_shop.dao.BrandDAO;
import com.sopra.phone_shop.model.BrandModel;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcBrandDAO implements BrandDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(BrandModel brand) throws SQLException {

		String sql = "INSERT INTO BRAND " +
				"(  ID, NOME, COUNTRY) VALUES ( ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"});
			ps.setInt(1, brand.getBrandId());
			ps.setString(2, brand.getNome());
			ps.setString(3, brand.getCountry());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Operative System  "+brand.getNome()+" , add with auto-increment because id: "+brand.getBrandId()+" already exist");

				//gestire il metodo con ID autoIncrement

				conn = dataSource.getConnection();
				String sql1 = "INSERT INTO BRAND " +
						"(NOME, COUNTRY) VALUES ( ?, ?)";

				PreparedStatement ps = conn.prepareStatement(sql1);

				ps.setString(1, brand.getNome());
				ps.setString(2, brand.getCountry());

				ps.executeUpdate();
				ps.close();

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
	public BrandModel findBrandById(int BrandId){

		String sql = "SELECT * FROM BRAND where id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, BrandId);
			BrandModel brand = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				brand = new BrandModel(
						rs.getInt("ID"),
						rs.getString("NOME"),
						rs.getString("COUNTRY")

				);
			}
			rs.close();
			ps.close();
			return brand;
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











