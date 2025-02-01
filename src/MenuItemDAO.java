import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAO {

    // ✅ 1. Добавление нового блюда (Create)
    public void addMenuItem(String name, double price, String category) {
        String sql = "INSERT INTO MenuItem (name, price, category) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setString(3, category);
            stmt.executeUpdate();
            System.out.println("✅ Блюдо добавлено: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ 2. Получение списка блюд (Read)
    public List<String> getMenuItems() {
        List<String> menu = new ArrayList<>();
        String sql = "SELECT * FROM MenuItem";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                menu.add(rs.getInt("id") + ". " + rs.getString("name") + " - $" + rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    // ✅ 3. Обновление блюда (Update)
    public void updateMenuItem(int id, String newName, double newPrice, String newCategory) {
        String sql = "UPDATE MenuItem SET name = ?, price = ?, category = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setDouble(2, newPrice);
            stmt.setString(3, newCategory);
            stmt.setInt(4, id);
            int updatedRows = stmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("✅ Блюдо обновлено: " + newName);
            } else {
                System.out.println("❌ Блюдо с ID " + id + " не найдено.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ 4. Удаление блюда (Delete)
    public void deleteMenuItem(int id) {
        String sql = "DELETE FROM MenuItem WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int deletedRows = stmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("✅ Блюдо удалено с ID: " + id);
            } else {
                System.out.println("❌ Блюдо с ID " + id + " не найдено.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}