package rebrin.ad241.lab2;

public class Item {
    private String name;        // найменування товару
    private float price;        // ціна товару

    /**
     * Це конструктор з перевіркою на негативну ціну
     */
    public Item(String name, float price) {
        this.name = name;
        this.price = (price < 0) ? 0 : price; // якщо чи ціна негативна
    }

    /**
     * Цей метод підвищує ціну на відсоток
     * @param procent відсоток, який впливає на ціну
     */
    public void upPrice(float procent) {
        price += price * (procent / 100);
    }

    /**
     * Цей метод понижує ціну на відсоток та перевіряє чи нова ціна
     * не стає негативною, у такому випадку їх присвоюється
     * значення 0
     * @param procent відсоток, який впливає на ціну
     */
    public void downPrice(float procent) {
        float newPrice = price - (price * (procent / 100));
        // якщо стає негативною, ставимо 0
        price = (newPrice < 0) ? 0 : newPrice;
    }

    /**
     * Цей метод  виконує інкапсуляцію імені
     */
    public String getName() {
        return name;
    }

    /**
     * Цей метод виконує інкапсуляцію ціни
     */
    public float getPrice() {
        return price;
    }
}
