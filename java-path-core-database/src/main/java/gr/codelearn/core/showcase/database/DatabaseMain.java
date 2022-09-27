package gr.codelearn.core.showcase.database;

import java.sql.Connection;

public class DatabaseMain {
	public static void main(String[] args) {
		Connection connection = JDBCConnection.getConnection();
	}

}
