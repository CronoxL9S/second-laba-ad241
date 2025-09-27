package rebrin.ad241.lab2;

public class Cart {
    private Item[] stack;        // масив для реалізації стека
    private int topIndex;        // покажчик на вершину стека
    private int maxCapacity;     // максимальна кількість елементів

    /**
     * Це конструктор зі створенням стека
     * @param maxCapacity визначає максимальну ємність
     */
    public Cart(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.stack = new Item[maxCapacity];
        this.topIndex = -1;
    }

    /**
     * Цей метод додає новий товар в кошик і перевіряє,
     * чи не переповнений кошик
     * @param item передає який товар треба додати
     */
    public boolean addItem(Item item) {
        if (topIndex >= maxCapacity - 1) {                          // перевірка ємності
            System.out.println("Помилка! Кошик переповнений.");
            return false;
        }

        topIndex++;              // збільшуємо індекс вершини
        stack[topIndex] = item;  // додаємо товар на вершину
        return true;             // успішно додано
    }

    /**
     * Цей метод видаляє останній доданий елемент, і перевіряє,
     * чи не порожній кошик
     */
    public Item deleteItem() {
        if (topIndex < 0) {
            System.out.println("Помилка! Кошик порожній.");
            return null;  // нічого видаляти
        }

        Item removedItem = stack[topIndex];  // зберігаємо товар для повернення
        stack[topIndex] = null;              // очищаємо місце
        topIndex--;                          // зменшуємо індекс вершини
        return removedItem;                  // повертаємо видалений товар
    }

    /**
     * Цей метод рахує остаточну суму всіх товарів у кошику
     */
    public float totalPrice() {
        float total = 0;
        for (int i = 0; i <= topIndex; i++) {
            total += stack[i].getPrice();
        }
        return total;
    }

    /**
     * Цей метод підвищує ціни всіх товарів у кошику на відсоток
     * @param procent визначає потрібний відсоток
     */
    public void upAllPrices(float procent) {
        for (int i = 0; i <= topIndex; i++) {
            stack[i].upPrice(procent);
        }
    }

    /**
     * Цей метод понижує ціни всіх товарів у кошику на відсоток
     * @param procent визначає потрібний відсоток
     */
    public void downAllPrices(float procent) {
        for (int i = 0; i <= topIndex; i++) {
            stack[i].downPrice(procent);
        }
    }

    /**
     * Цей метод є допоміжним, і показує кількість товарів в кошику
     */
    public int itemCount() {
        return topIndex + 1;
    }
}
