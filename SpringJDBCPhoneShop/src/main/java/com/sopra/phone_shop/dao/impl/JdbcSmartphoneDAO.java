package com.sopra.phone_shop.dao.impl;

import com.sopra.phone_shop.dao.SmartphoneDAO;
import com.sopra.phone_shop.model.SmartphoneModel;


import javax.sql.DataSource;
import java.sql.*;

public class JdbcSmartphoneDAO implements SmartphoneDAO{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert( SmartphoneModel smartphone) throws SQLException {

		String sql = "INSERT INTO SMARTPHONE " +
				"(  ID, NOME, RAM, CPUU, DISPLAYSIZE, DISPLAYPPI, DISPLAYRESOLUTION, SIZE, OPSYS_ID, BRAND_ID) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"});
			ps.setInt(1, smartphone.getSmartId());
			ps.setString(2, smartphone.getName());
			ps.setString(3, smartphone.getRam());
			ps.setString(4, smartphone.getCpuu());
			ps.setString(5, smartphone.getDisplaySize());
			ps.setInt(6, smartphone.getDisplayPpi());
			ps.setString(7, smartphone.getDisplayResolution());
			ps.setString(8, smartphone.getSize());
			ps.setInt(9, smartphone.getOpsysId());
			ps.setInt(10, smartphone.getBrandId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				//gestire il metodo con ID autoIncrement

				conn = dataSource.getConnection();
				String sql1 = "INSERT INTO SMARTPHONE " +
						"(NOME, RAM, CPUU, DISPLAYSIZE, DISPLAYPPI, DISPLAYRESOLUTION, SIZE, OPSYS_ID, BRAND_ID) VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.setString(1, smartphone.getName());
				ps.setString(2, smartphone.getRam());
				ps.setString(3, smartphone.getCpuu());
				ps.setString(4, smartphone.getDisplaySize());
				ps.setInt(5, smartphone.getDisplayPpi());
				ps.setString(6, smartphone.getDisplayResolution());
				ps.setString(7, smartphone.getSize());
				ps.setInt(8,smartphone.getOpsysId());
				ps.setInt(9,smartphone.getBrandId());
				;
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

}@Override
		public SmartphoneModel findSmartphoneById ( int SmartId){

			String sql = "SELECT * FROM SMARTPHONE where id = ?";

			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, SmartId);
				SmartphoneModel smartphone = null;
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					smartphone = new SmartphoneModel(
							rs.getInt("ID"),
							rs.getString("NOME"),
							rs.getString("RAM"),
							rs.getString("CPUU"),
							rs.getString("DISPLAYSIZE"),
							rs.getInt("DISPLAYPPI"),
							rs.getString("DISPLAYRESOLUTION"),
							rs.getString("SIZE"),
							rs.getInt("OPSYS_ID"),
							rs.getInt("BRAND_ID")
					);
				}
				rs.close();
				ps.close();
				return smartphone;
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






