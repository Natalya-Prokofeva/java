/**Задача 3. Удаление пустых строк из текста
Дана строка с несколькими строками текста, разделенными переводами строки.
Напишите метод, который удаляет все пустые строки из текста.
Пример:
line1
line2
line3
Результат:
line1
line2
line3*/

public class RemoveEmptyLines {
    public static String removeEmptyLines(String text) {
        // Разделяем текст на строки
        String[] lines = text.split("\\r?\\n");
        
        // Используем StringBuilder для построения результата
        StringBuilder result = new StringBuilder();
        
        for (String line : lines) {
            // Удаляем лишние пробелы с начала и конца строки
            line = line.trim();
            // Проверяем, является ли строка пустой
            if (!line.isEmpty()) {
                result.append(line).append("\n");
            }
        }
        
        // Удаляем последний переход на новую строку, если он есть
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "line1\n\nline2\nline3\n\n\nline4";
        System.out.println("Исходный текст:\n" + text);
        String result = removeEmptyLines(text);
        System.out.println("Результат:\n" + result);
    }
}
