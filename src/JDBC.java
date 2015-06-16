import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private Connection connection;
	private Statement statement;

	// constructor establishes a connection with the db
	public JDBC() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager
					.getConnection("jdbc:sqlite:swift.db");
			this.statement = connection.createStatement();
			statement.setQueryTimeout(30);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// return the song name based on id
	public ResultSet getSongTitleById(int id) {
		ResultSet rs = null;
		try {
			rs = this.statement
					.executeQuery("SELECT Title FROM Songs WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		try {
			rs = this.statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void closeDb() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}