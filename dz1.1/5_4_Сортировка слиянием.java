/**Задача 4. Сортировка слиянием
Напишите программу, которая реализует сортировку слиянием. Программа
должна содержать два основных метода: merge для объединения двух
отсортированных массивов в один отсортированный, и mergeSort для
сортировки массива с использованием сортировки слиянием.
*/
import java.util.Arrays;

public class MergeSort {

    // Метод, который сортирует массив с помощью сортировки слиянием
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Базовый случай: массив из одного элемента уже отсортирован
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Рекурсивная сортировка каждой половины
        mergeSort(left);
        mergeSort(right);

        // Объединение отсортированных половин
        merge(array, left, right);
    }

    // Метод, который объединяет два отсортированных массива в один
    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Сравнение элементов обоих массивов и добавление наименьшего в результирующий массив
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Копирование оставшихся элементов из левого массива
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Копирование оставшихся элементов из правого массива
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Тестирование
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Перед сортировкой: " + Arrays.toString(array));
        mergeSort(array);
        System.out.println("После сортировки: " + Arrays.toString(array));
    }
}
