package exam;

public class Main1 {
	private statasdfasdfic final String QUERY1 = "CREATE TABLE `exam2`.`users` (\n" +
			"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"  `name` VARCHAR(60) NULL,\n" +
			"  `email` VARCHAR(60) NULL,\n" +
			"  `password` VARCHAR(60) NULL,\n" +
			"  PRIMARY KEY (`id`),\n" +
			"  UNIQUE INDEX `email_UNIQUE` (`email` ASC));";
	private static final String QUERY2 = "CREATE TABLE `exam2`.`messages` (\n" +
			"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"  `message` TEXT NULL,\n" +
			"  `user_id` INT NULL,\n" +
			"  PRIMARY KEY (`id`),\n" +
			"  INDEX `fk_messages_1_idx` (`user_id` ASC),\n" +
			"  CONSTRAINT `fk_messages_1`\n" +
			"    FOREIGN KEY (`user_id`)\n" +
			"    REFERENCES `exam2`.`users` (`id`)\n" +
			"    ON DELETE NO ACTION\n" +
			"    ON UPDATE NO ACTION);\n";
	private static final String QUERY3 = "CREATE TABLE `exam2`.`items` (\n" +
			"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"  `name` VARCHAR(40) NULL,\n" +
			"  `description` TEXT NULL,\n" +
			"  `price` DECIMAL(7,2) NULL,\n" +
			"  PRIMARY KEY (`id`));\n";
	private static final String QUERY4 = "CREATE TABLE `exam2`.`orders` (\n" +
			"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"  `description` TEXT NULL,\n" +
			"  `created` DATE NULL,\n" +
			"  `user_id` INT NULL,\n" +
			"  PRIMARY KEY (`id`),\n" +
			"  INDEX `fk_orders_1_idx` (`user_id` ASC),\n" +
			"  CONSTRAINT `fk_orders_1`\n" +
			"    FOREIGN KEY (`user_id`)\n" +
			"    REFERENCES `exam2`.`users` (`id`)\n" +
			"    ON DELETE NO ACTION\n" +
			"    ON UPDATE NO ACTION);";
	private static final String QUERY5 = "CREATE TABLE `exam2`.`items_orders` (\n" +
			"  `id` INT NOT NULL AUTO_INCREMENT,\n" +
			"  `items_id` INT NOT NULL,\n" +
			"  `orders_id` INT NOT NULL,\n" +
			"  PRIMARY KEY (`id`),\n" +
			"  INDEX `fk_items_orders_1_idx` (`orders_id` ASC),\n" +
			"  INDEX `fk_items_orders_2_idx` (`items_id` ASC),\n" +
			"  CONSTRAINT `fk_items_orders_1`\n" +
			"    FOREIGN KEY (`orders_id`)\n" +
			"    REFERENCES `exam2`.`orders` (`id`)\n" +
			"    ON DELETE NO ACTION\n" +
			"    ON UPDATE NO ACTION,\n" +
			"  CONSTRAINT `fk_items_orders_2`\n" +
			"    FOREIGN KEY (`items_id`)\n" +
			"    REFERENCES `exam2`.`items` (`id`)\n" +
			"    ON DELETE NO ACTION\n" +
			"    ON UPDATE NO ACTION);";
	
	public static void main(String[] args){
		// wywołaj przygotowane zapytania
	}

}
