import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant_db"; // Замените на вашу БД
    private static final String USER = "postgres";  // Ваш логин
    private static final String PASSWORD = "1111";  // Ваш пароль

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // ✅ Явная регистрация драйвера
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ Драйвер PostgreSQL не найден!", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}