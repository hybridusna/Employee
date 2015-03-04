package webapp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeDataSource extends AdapterDataSource {

	String className;
	String url;
	String user;
	String password;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return getConnection(user, password);
	}

	@Override
	public Connection getConnection(String user, String password)
			throws SQLException {

		Connection con = null;

		try {
			Class.forName(className);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SQLException("Connection fail", e);
		} finally {

		}

		return con;
	}

}
