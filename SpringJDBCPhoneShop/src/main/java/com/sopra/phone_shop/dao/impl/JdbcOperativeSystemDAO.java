package com.sopra.phone_shop.dao.impl;

import com.sopra.phone_shop.dao.OperativeSystemDAO;
import com.sopra.phone_shop.model.OperativeSystemModel;


import javax.sql.DataSource;
import java.sql.*;

public class JdbcOperativeSystemDAO implements OperativeSystemDAO{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(OperativeSystemModel opsystem) throws SQLException {

		String sql = "INSERT INTO OPSYS " +
				"(  ID, DESCRIZIONE, COMPANY, OPENSOURCE) VALUES ( ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"});
			ps.setInt(1, opsystem.getOpId());
			ps.setString(2, opsystem.getDescrizione());
			ps.setString(3, opsystem.getCompany());
			ps.setInt(4, opsystem.getOpensource());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Operative System  "+opsystem.getDescrizione()+" , add with auto-increment because id: "+opsystem.getOpId()+" already exist");
				conn = dataSource.getConnection();
				String sql1 = "INSERT INTO OPSYS " +
						"(DESCRIZIONE, COMPANY, OPENSOURCE ) VALUES (  ?, ?, ?)";

				PreparedStatement ps = conn.prepareStatement(sql1);

				ps.setString(1, opsystem.getDescrizione());
				ps.setString(2, opsystem.getCompany());
				ps.setInt(3, opsystem.getOpensource());
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
		public OperativeSystemModel findOperativeSystemById ( int opId){

			String sql = "SELECT * FROM OPSYS where id = ?";

			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, opId);
				OperativeSystemModel opSystem = null;
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					opSystem = new OperativeSystemModel(
							rs.getInt("ID"),
							rs.getString("DESCRIZIONE"),
							rs.getString("COMPANY"),
							rs.getInt("OPENSOURCE")
					);
				}
				rs.close();
				ps.close();
				return opSystem;
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






