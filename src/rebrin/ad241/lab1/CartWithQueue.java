package rebrin.ad241.lab2;

/**
 * Створюємо клас для черги
 */
public class CartWithQueue {
    private Item[] queue;        // масив для реалізації черги
    private int front;           // індекс початку черги (звідки видаляємо)
    private int rear;            // індекс кінця черги (куди додаємо)
    private int size;            // поточна кількість елементів
    private int maxCapacity;     // максимальна кількість елементів

    /**
     * Це конструктор з максимальною кількістю елементів
     * @param maxCapacity визначає максимальну ємність
     */
    public CartQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.queue = new Item[maxCapacity];
        this.front = 0;          // початок черги
        this.rear = -1;          // кінець черги (-1 = порожня черга)
        this.size = 0;           // поточна кількість елементів
    }

    /**
     * Цей метод додає товар у кінець черги
     * @param item визначає потрібний товар
     */
    public boolean addItem(Item item) {
        if (size >= maxCapacity) {
            System.out.println("Помилка! Кошик переповнений.");
            return false;
        }

        rear = (rear + 1) % maxCapacity;  // циклічний масив
        queue[rear] = item;
        size++;
        return true;
    }

    /**
     * Цей метод видаляє товар з початку черги
     */
    public Item deleteItem() {
        if (size == 0) {
            System.out.println("Помилка! Кошик порожній.");
            return null;
        }

        Item removedItem = queue[front];
        queue[front] = null;              // очищаємо місце
        front = (front + 1) % maxCapacity; // циклічний масив
        size--;
        return removedItem;
    }

    /**
     * Цей метод рахує остаточну суму всіх товарів у кошику
     */
    public float totalPrice() {
        float total = 0;
        int currentIndex = front;

        for (int i = 0; i < size; i++) {
            total += queue[currentIndex].getPrice();
            currentIndex = (currentIndex + 1) % maxCapacity; // циклічний обхід
        }
        return total;
    }

    /**
     * Цей метод підвищує ціни всіх товарів у кошику на відсоток
     * @param procent визначає потрібний відсоток
     */
    public void upAllPrices(float procent) {
        int currentIndex = front;

        for (int i = 0; i < size; i++) {
            queue[currentIndex].upPrice(procent);
            currentIndex = (currentIndex + 1) % maxCapacity;
        }
    }

    /**
     * Цей метод понижує ціни всіх товарів у кошику на відсоток
     * @param procent визначає потрібний відсоток
     */
    public void downAllPrices(float procent) {
        int currentIndex = front;

        for (int i = 0; i < size; i++) {
            queue[currentIndex].downPrice(procent);
            currentIndex = (currentIndex + 1) % maxCapacity;
        }
    }

    /**
     * Цей метод є допоміжним, і показує кількість товарів в кошику
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
