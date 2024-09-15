/**Задача 4. Логирование операций с массивом во время поиска
минимального и максимального элементов
Реализуйте метод поиска минимального и максимального элементов массива.
После нахождения каждого элемента (минимального и максимального),
сделайте запись в лог-файл log.txt в формате год-месяц-день
час:минуты {минимальный элемент}, {максимальный элемент}.*/

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ArrayLogging {

    // Метод для поиска минимального и максимального элементов массива с логированием    
    public static void findMinMaxAndLog(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Массив пуст или равен null");
            return;
        }
        
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                log(min, max);
            }
            if (array[i] > max) {
                max = array[i];
                log(min, max);
            }
        }

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }
    
    // Метод для логирования минимального и максимального элементов
    private static void log(int min, int max) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        String logMessage = String.format("%s {мин: %d, макс: %d}", formattedDateTime, min, max);

        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(logMessage + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};

        System.out.println("Исходный массив: " + Arrays.toString(array));

        findMinMaxAndLog(array);
    }
}
