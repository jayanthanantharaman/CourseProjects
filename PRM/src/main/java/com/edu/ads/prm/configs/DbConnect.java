package com.edu.ads.prm.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.edu.ads.prm.common.DBConstants;

public class DbConnect {

	public Connection connection;
	private PreparedStatement statement;
	public static DbConnect dbConnect;


	private DbConnect() {
		try {
			Class.forName(DBConstants.DB_DRIVER).newInstance();
			this.connection = (Connection) DriverManager.getConnection(DBConstants.DB_URL, DBConstants.DB_USERNAME,
					DBConstants.DB_PASSWORD);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public static synchronized DbConnect getDbConnection() {
		if (dbConnect == null) {
			dbConnect = new DbConnect();
		}
		return dbConnect;
	}

	/**
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet query(String query, List<Object> parameters) throws SQLException {
		ResultSet resultSet;
		statement = dbConnect.connection.prepareStatement(query);
		int paramIndex = 0;
		for (Object obj : parameters) {
			++paramIndex;
			statement.setObject(paramIndex, obj);
		}
		resultSet = statement.executeQuery();
		return resultSet;
	}

	/**
	 * @param updateQuery
	 * @return
	 * @throws SQLException
	 */
	public int update(String updateQuery, List<Object> parameters) throws SQLException {
		int result;
		statement = dbConnect.connection.prepareStatement(updateQuery);
		int paramIndex = 0;
		for (Object obj : parameters) {
			++paramIndex;
			statement.setObject(paramIndex, obj);
		}
		result = statement.executeUpdate();
		return result;

	}

	public void closeResources() throws SQLException {
		statement.close();
	}

}
