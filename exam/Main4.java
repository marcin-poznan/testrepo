package exam;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.Scanner;

public class Main4 {


    public static void main(String[] args) {

        System.out.println("Podaj nazwę produktu:");
        String itemName = askForString();

        System.out.println("Podaj opis produktu:");
        String itemDescription = askForString();

        System.out.println("Podaj cenę produktu:");
        double price = askForPrice();

        System.out.println();
        System.out.println(itemName + " " + itemDescription + " " + price);

        addData(itemName, itemDescription, price);

    }

    // dodawanie danych
    public static void addData(String itemName, String itemDescription, double price) {

        String sql = "INSERT INTO items(name, description, price) VALUES(?, ?, ?)";

        try (Connection connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exam2" + "?useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, itemName);
            preparedStatement.setString(2, itemDescription);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
            System.out.println("Dane zostały wprowadzone do bazy danych.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String askForString() {
        Scanner scan = new Scanner(System.in);
        String line = "";
        boolean isLineOk = false;
        while (!isLineOk) {
            line = scan.nextLine().trim();
            if (line.equals("")) {
                continue;
            } else {
                break;
            }
        }
        return line;
    }

    public static double askForPrice() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextDouble()) {
            System.out.println("To nie jest liczba zmiennoprzecinkowa, podaj liczbę!");
            scan.next();
        }
        int number = scan.nextInt();
        return number;
    }

}
