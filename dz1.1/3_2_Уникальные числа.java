/**Задача 2. Уникальные числа
Напишите метод, который принимает целочисленный массив и возвращает
новый массив, содержащий только уникальные элементы из исходного
массива.
Пример:
[1, 2, 2, 3, 4, 4, 5]
Результат:
[1, 2, 3, 4, 5]*/

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueNumbers {

    public static int[] getUniqueNumbers(int[] array) {
        // Создаем LinkedHashSet для хранения уникальных элементов
        Set<Integer> uniqueNumbersSet = new LinkedHashSet<>();
        
        // Проход по элементам массива и добавление в LinkedHashSet
        for (int num : array) {
            uniqueNumbersSet.add(num);
        }
        
        // Преобразование LinkedHashSet в массив
        int[] result = new int[uniqueNumbersSet.size()];
        int index = 0;
        for (int num : uniqueNumbersSet) {
            result[index++] = num;
        }
        
        // Возврат массива с уникальными элементами
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        int[] uniqueArray = getUniqueNumbers(array);
        System.out.println(Arrays.toString(uniqueArray)); // [1, 2, 3, 4, 5]
    }
}

