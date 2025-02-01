import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuItemDAO menuItemDAO = new MenuItemDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📌 Меню управления рестораном:");
            System.out.println("1. Добавить блюдо");
            System.out.println("2. Показать меню");
            System.out.println("3. Обновить блюдо");
            System.out.println("4. Удалить блюдо");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Читаем перевод строки

            switch (choice) {
                case 1:
                    System.out.print("Введите название блюда: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите цену блюда: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Введите категорию блюда: ");
                    String category = scanner.nextLine();
                    menuItemDAO.addMenuItem(name, price, category);
                    break;

                case 2:
                    System.out.println("📜 Меню ресторана:");
                    menuItemDAO.getMenuItems().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Введите ID блюда для обновления: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое название: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новую цену: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Введите новую категорию: ");
                    String newCategory = scanner.nextLine();
                    menuItemDAO.updateMenuItem(updateId, newName, newPrice, newCategory);
                    break;

                case 4:
                    System.out.print("Введите ID блюда для удаления: ");
                    int deleteId = scanner.nextInt();
                    menuItemDAO.deleteMenuItem(deleteId);
                    break;

                case 5:
                    System.out.println("👋 Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Неверный ввод. Попробуйте снова.");
            }
        }
    }
}