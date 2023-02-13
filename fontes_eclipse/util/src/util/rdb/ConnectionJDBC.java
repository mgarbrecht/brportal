package util.rdb;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public final class ConnectionJDBC {

	private static String jdbcDriver;
	private static String jdbcURL;

	public ConnectionJDBC() {
	}

	private static void loadProperties(String rdbName)
			throws FileNotFoundException, IOException, NullPointerException,
			ClassNotFoundException, SQLException {

		Properties sysProps = System.getProperties();
		FileInputStream propsFile;
		try {
			propsFile = new FileInputStream(new StringBuilder(
					sysProps.getProperty("catalina.home"))
					.append(sysProps.getProperty("file.separator"))
					.append("webapps")
					.append(sysProps.getProperty("file.separator"))
					.append("brportal")
					.append(sysProps.getProperty("file.separator"))
					.append("rdbutil")
					.append(sysProps.getProperty("file.separator"))
					.append("rdb_class_drivers.properties").toString());
		} catch (FileNotFoundException e) {
			try {
				propsFile = new FileInputStream(new StringBuilder(
						sysProps.getProperty("catalina.home"))
						.append(sysProps.getProperty("file.separator"))
						.append("webapps")
						.append(sysProps.getProperty("file.separator"))
						.append("brportal")
						.append(sysProps.getProperty("file.separator"))
						.append("rdbutil")
						.append(sysProps.getProperty("file.separator"))
						.append("rdb_class_drivers.properties").toString());
			} catch (FileNotFoundException exc) {
				throw new FileNotFoundException(
						"File RDBUtil not found in paths.");
			}
		}
		try {
			Properties props = new Properties();
			props.load(propsFile);
			jdbcDriver = props.getProperty(rdbName);
			if (jdbcDriver == null) {
				throw new NullPointerException(
						new StringBuilder("Propriedade ")
								.append(rdbName)
								.append(" não especificada no arquivo ...RDBUtil")
								.append(sysProps.getProperty("file.separator"))
								.append("rdb_class_drivers.properties.")
								.toString());
			}
		} catch (IOException e) {
			throw new IOException(new StringBuilder("Não pode ler ... RDBUtil")
					.append(sysProps.getProperty("file.separator"))
					.append("rdb_class_drivers.properties.").toString());
		}
		try {
			propsFile = new FileInputStream(new StringBuilder(
					sysProps.getProperty("catalina.home"))
					.append(sysProps.getProperty("file.separator"))
					.append("webapps")
					.append(sysProps.getProperty("file.separator"))
					.append("brportal")
					.append(sysProps.getProperty("file.separator"))
					.append("rdbutil")
					.append(sysProps.getProperty("file.separator"))
					.append("rdb_jdbc_urls.properties").toString());
		} catch (FileNotFoundException e) {
			try {
				propsFile = new FileInputStream(new StringBuilder(
						sysProps.getProperty("catalina.home"))
						.append(sysProps.getProperty("file.separator"))
						.append("webapps")
						.append(sysProps.getProperty("file.separator"))
						.append("brportal")
						.append(sysProps.getProperty("file.separator"))
						.append("rdbutil")
						.append(sysProps.getProperty("file.separator"))
						.append("rdb_jdbc_urls.properties").toString());
			} catch (FileNotFoundException exc) {
				throw new FileNotFoundException(
						"Não foi encontrado o arquivo no diretório.");
			}
		}
		try {
			Properties props = new Properties();
			props.load(propsFile);
			jdbcURL = props.getProperty(rdbName);
			if (jdbcURL == null) {
				throw new NullPointerException(
						new StringBuilder("Propriedade ")
								.append(rdbName)
								.append(" não especificada no arquivo ...RDBUtil")
								.append(sysProps.getProperty("file.separator"))
								.append("rdb_jdbc_urls.properties.").toString());
			}
		} catch (IOException e) {
			throw new IOException(new StringBuilder(
					"Não foi possível ler ... RDBUtil")
					.append(sysProps.getProperty("file.separator"))
					.append("rdb_jdbc_urls.properties.").toString());
		}
	}

	public static Connection get(String rdbName, String rdbUser, String userPwd)
			throws FileNotFoundException, IOException, NullPointerException,
			ClassNotFoundException, SQLException {
		loadProperties(rdbName);
		Class.forName(jdbcDriver);
		Connection conn = DriverManager
				.getConnection(jdbcURL, rdbUser, userPwd);
		return conn;
	}

	public static String getJdbcDriver(String rdbName)
			throws FileNotFoundException, IOException, NullPointerException,
			ClassNotFoundException, SQLException {
		loadProperties(rdbName);
		return jdbcDriver;
	}

	public static String getJdbcURL(String rdbName)
			throws FileNotFoundException, IOException, NullPointerException,
			ClassNotFoundException, SQLException {
		loadProperties(rdbName);
		return jdbcURL;
	}
}
