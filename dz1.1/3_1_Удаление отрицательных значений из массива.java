/**Задание 1. Удаление отрицательных значений из массива
Реализуйте метод, который принимает на вход целочисленный массив и
удаляет все отрицательные числа. Метод должен вернуть массив, содержащий
только неотрицательные числа.
Пример:
[-1, 2, -3, 4, -5, 6]
Результат:
[2, 4, 6]*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegativeRemover {

    public static int[] removeNegatives(int[] array) {
        // Создаем список для хранения неотрицательных чисел
        List<Integer> nonNegativeList = new ArrayList<>();

        // Проходим по каждому элементу массива
        for (int num : array) {
            if (num >= 0) {
                nonNegativeList.add(num); // Добавляем неотрицательные числа в список
            }
        }

        // Преобразуем ArrayList в массив int[]
        int[] result = new int[nonNegativeList.size()];
        for (int i = 0; i < nonNegativeList.size(); i++) {
            result[i] = nonNegativeList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1, 2, -3, 4, -5, 6};
        int[] filteredArray = removeNegatives(array);
        System.out.println(Arrays.toString(filteredArray));
    }
}
