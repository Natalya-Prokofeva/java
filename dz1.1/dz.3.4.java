/**Задача 4*. Среднее значение массива
Напишите метод, который принимает массив целых чисел и возвращает
среднее значение элементов массива, округленное до ближайшего целого
числа.
Пример:
[4, 2, 7, 5, 1]
Результат:
4*/
public class AverageCalculator {

    public static int calculateAverage(int[] numbers) {
        // Проверяем, что массив не пуст
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        // Вычисление суммы элементов массива
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Вычисление среднего значения
        double average = (double) sum / numbers.length;

        // Округление до ближайшего целого числа
        int roundedAverage = (int) Math.round(average);

        return roundedAverage;
    }

    public static void main(String[] args) {
        // Пример массива целых чисел
        int[] numbers = {4, 2, 7, 5, 1};

        // Вычисление среднего значения
        int average = calculateAverage(numbers);

        // Вывод результата
        System.out.println("Среднее значение: " + average);
    }
}
