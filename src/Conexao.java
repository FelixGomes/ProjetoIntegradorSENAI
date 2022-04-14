import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = util.ConnectionUtil.getConnection();
		Statement stmt = connection.createStatement();
		
	}
}