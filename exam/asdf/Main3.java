package exam;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("Podaj id użytkownika:");
        int userId = askForId();
        getUsersMessages(userId);
        System.out.println();
        getUsersOrders(userId);

    }

    // pobieranie danych z bazy danych
    public static void getUsersMessages(int userId) {

//        String sql = "SELECT * FROM messages JOIN users\n" +
//                "ON messages.user_id=users.id\n" +
//                "WHERE users.id=?;";

        String sql2 = "SELECT * FROM messages JOIN users\n" +
                "ON messages.user_id=users.id\n" +
                "WHERE users.id=" + userId +";";

        try (Connection connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exam2" + "?useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            //preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery(sql2);

            System.out.println("Wiadomości użytkownika o id " + userId);
            while (resultSet.next()) {
                String message = resultSet.getString("message");
                System.out.println("Wiadomość: " + message);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // pobieranie danych z bazy danych
    public static void getUsersOrders(int userId) {

        String sql = "SELECT * FROM orders\n" +
                "JOIN users ON orders.user_id=users.id\n" +
                "WHERE users.id=" + userId +";";

        try (Connection connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exam2" + "?useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            System.out.println("Zamówienia użytkownika o id " + userId);
            while (resultSet.next()) {
                String orderDescription = resultSet.getString("description");
                int orderId = resultSet.getInt("id");
                System.out.println("id: " + orderId + ", opis: " + orderDescription);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int askForId() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("To nie jest liczba, podaj liczbę!");
            scan.next();
        }
        int number = scan.nextInt();
        return number;
    }

}
