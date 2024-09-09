/**Задача 2. Вывод всех четных чисел от 1 до 100
Напишите метод printEvenNums, который выведет на экран все четные числа
в промежутке от 1 до 100, каждое на новой строке.*/

public class EvenNumbersPrinter {

    /**
     * Выводит все четные числа от 1 до 100.
     */
    public static void printEvenNums() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        printEvenNums();
    }
}
