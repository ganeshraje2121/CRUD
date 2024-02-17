import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@//192.168.1.24:1521/orclnew1";
        String username = "C##TEST_ADMIN";
        String password = "system123#";

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
