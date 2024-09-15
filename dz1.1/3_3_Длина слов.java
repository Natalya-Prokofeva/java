/**Задача 3. Длина слов
Реализуйте метод, который принимает на вход массив строк и возвращает
новый массив, содержащий только строки, длина которых больше 3 символов.
Пример:
["cat", "elephant", "dog", "giraffe"]
Результат:
["elephant", "giraffe"]*/

import java.util.ArrayList;

public class StringFilter {

    public static String[] filterStringsByLength(String[] inputArray) {
        // Создаём ArrayList для хранения строк, длина которых больше 3 символов
        ArrayList<String> filteredList = new ArrayList<>();

        // Итерируемся через массив строк
        for (String str : inputArray) {
            // Проверяем длину каждой строки
            if (str.length() > 3) {
                // Добавляем строку в ArrayList, если она удовлетворяет условию
                filteredList.add(str);
            }
        }

        // Преобразуем ArrayList в массив строк
        String[] resultArray = new String[filteredList.size()];
        resultArray = filteredList.toArray(resultArray);

        // Возвращаем полученный массив
        return resultArray;
    }

    public static void main(String[] args) {
        // Пример массива строк
        String[] strings = {"cat", "elephant", "dog", "giraffe"};

        // Вызов метода фильтрации
        String[] filteredStrings = filterStringsByLength(strings);

        // Вывод результатов
        for (String str : filteredStrings) {
            System.out.println(str);
        }
    }
}
