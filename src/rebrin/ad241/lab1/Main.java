package rebrin.ad241.lab2;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t---Мій кошик---\n");

        /**
         * Створюємо масив кошику, з ємністю 7 товарів
         */
        Cart cart = new Cart(7);

        /**
         * Створюємо товари для кошику
         */
        Item milk = new Item("Молоко", 60.0f);
        Item cheese = new Item("Сир", 44.5f);
        Item potato = new Item("Картопля", 24.0f);
        Item onion = new Item("Цибуля", 12.7f);
        Item chicken = new Item("Курка", 91.3f);
        Item salt = new Item("Сіль", 19.2f);

        /**
         * Заповнюємо кошик створеними товарами
         */
        System.out.println("Додаємо товари до кошика:");

        cart.addItem(milk);
        System.out.println(" Додано: " + milk.getName() + " - " + milk.getPrice() + " грн");

        cart.addItem(cheese);
        System.out.println(" Додано: " + cheese.getName() + " - " + cheese.getPrice() + " грн");

        cart.addItem(potato);
        System.out.println(" Додано: " + potato.getName() + " - " + potato.getPrice() + " грн");

        cart.addItem(onion);
        System.out.println(" Додано: " + onion.getName() + " - " + onion.getPrice() + " грн");

        cart.addItem(chicken);
        System.out.println(" Додано: " + chicken.getName() + " - " + chicken.getPrice() + " грн");

        cart.addItem(salt);
        System.out.println(" Додано: " + salt.getName() + " - " + salt.getPrice() + " грн");

        System.out.println("Кількість товарів у кошику: " + cart.itemCount());

        /**
         * Виводимо ціни товарів
         */
        float totalPrice = cart.totalPrice();
        System.out.println("\nЗагальна сума товарів: " + totalPrice + " грн\n");

        /**
         * Підвищуємо ціни на 25%
         */
        System.out.println("\tПідвищуємо ціни на 25%");
        cart.upAllPrices(25.0f);
        float newUpTotalPrice = cart.totalPrice();
        System.out.println("Нова сума після підвищення на 25%%: " + newUpTotalPrice + " грн\n");

        /**
         * Знижуємо ціни на 40%
         */
        System.out.println("\tЗнижуємо ціни на 30%");
        cart.downAllPrices(40.0f);
        float newDownTotalPrice = cart.totalPrice();
        System.out.println("Нова сума після зниження на 40%: " + newDownTotalPrice + " грн\n");

        /**
         * Тестування видалення товарів
         */
        System.out.println("\tТестування роботи стека");
        System.out.println("Видаляємо останній доданий товар:");
        Item removedItem = cart.deleteItem();
        if (removedItem != null) {
            System.out.println(" Видалено: " + removedItem.getName() + " - " + removedItem.getPrice() + " грн");
        }

        System.out.println("Кількість товарів після видалення: " + cart.itemCount());
        System.out.printf("Сума після видалення: " + cart.totalPrice() + "грн\n");
    }
}