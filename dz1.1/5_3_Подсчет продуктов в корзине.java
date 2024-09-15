/**Задача 3. Подсчет продуктов в корзине
Создайте программу для учета продуктов в корзине. Программа должна
позволять добавлять, удалять, обновлять количество продуктов, а также
проверять наличие продуктов в корзине. Используйте HashMap для хранения
продуктов и их количества.
Методы:
● addProduct(String product, Integer quantity): Добавляет
продукт с указанным количеством в корзину. Если продукт уже есть,
увеличивает его количество.
● removeProduct(String product): Удаляет продукт из корзины. Если
продукт отсутствует, ничего не делает.
● updateQuantity(String product, Integer quantity): Обновляет
количество продукта в корзине. Если продукта нет, ничего не делает.
● checkProduct(String product): Проверяет, есть ли продукт в
корзине и возвращает его количество. Если продукта нет, возвращает 0.
● showBasket(): Выводит все продукты и их количество в корзине.*/
import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    private Map<String, Integer> cart = new HashMap<>();

    // Метод добавления продукта
    public void addProduct(String product, Integer quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Метод удаления продукта
    public void removeProduct(String product) {
        cart.remove(product);
    }

    // Метод обновления количества продукта
    public void updateQuantity(String product, Integer quantity) {
        if (cart.containsKey(product)) {
            cart.put(product, quantity);
        }
    }

    // Метод проверки продукта
    public int checkProduct(String product) {
        return cart.getOrDefault(product, 0);
    }

    // Метод вывода всей корзины
    public void showBasket() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

// Класс для проверки работы программы
public class BasketPrinter {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Яблоки", 5);
        cart.addProduct("Бананы", 3);
        cart.addProduct("Яблоки", 2); // Увеличиваем количество яблок
        cart.showBasket();

        System.out.println("Яблоки в корзине: " + cart.checkProduct("Яблоки"));
        System.out.println("Огурцы в корзине: " + cart.checkProduct("Огурцы"));

        cart.updateQuantity("Бананы", 10);
        cart.showBasket();

        cart.removeProduct("Яблоки");
        cart.showBasket();
    }
}
