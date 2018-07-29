package exam;

public class Main2 {

	private static final String QUERY1 = "select* from items where price > 50 ORDER BY price ASC;";
	private static final String QUERY2 = "INSERT INTO `exam2`.`items` (`name`, `description`) VALUES ('product 1', 'desc1');";
	private static final String QUERY3 = "DELETE FROM `exam2`.`users` WHERE `id`='7';";
	private static final String QUERY4 = "SELECT * FROM users JOIN messages ON users.id=messages.user_id ORDER BY users.id ASC;";
	private static final String QUERY5 = "SELECT MAX(price) FROM items\n" +
			"JOIN items_orders ON items.id=items_orders.items_id\n" +
			"JOIN orders ON orders.id=items_orders.orders_id where orders.id=2;";
	private static final String QUERY6 = "SELECT * FROM orders WHERE created=2017-11-12;";
	private static final String QUERY7 = "INSERT INTO items_orders(orders_id, items_id) VALUES (6,2);";
	
}
