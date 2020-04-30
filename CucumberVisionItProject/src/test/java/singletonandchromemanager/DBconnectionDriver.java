package singletonandchromemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBconnectionDriver {
	private static DBconnectionDriver instance;
	private Connection conn;


	private DBconnectionDriver(String url) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public static DBconnectionDriver getInstance(String url) throws SQLException {
		if (instance==null) {
			instance= new DBconnectionDriver(url);
		}else if (instance.getConnection().isClosed()) {
			instance= new DBconnectionDriver(url);
		}
	return instance;
	}
}