/**Задача 2. Создание CSV-строки из массива объектов
Дан массив объектов, где каждый объект представляет собой строку данных, и
массив заголовков. Создайте строку CSV, где строки данных разделяются новой
строкой, а значения в строках разделяются запятыми.
Пример:
String[] headers = {"Name", "Age", "City"};
String[][] data = {
{"John", "30", "New York"},
{"Alice", "25", "Los Angeles"},
{"Bob", "35", "Chicago"}
};
Результат:
Name,Age,City
John,30,New York
Alice,25,Los Angeles
Bob,35,Chicago*/

public class CSVGenerator {

    public static String generateCSV(String[] headers, String[][] data) {
        // Используем StringBuilder для построения строки
        StringBuilder csvBuilder = new StringBuilder();
        
        // Добавляем заголовки
        for (int i = 0; i < headers.length; i++) {
            csvBuilder.append(headers[i]);
            if (i < headers.length - 1) {
                csvBuilder.append(",");
            }
        }
        csvBuilder.append("\n");
        
        // Добавляем строки данных
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                csvBuilder.append(row[i]);
                if (i < row.length - 1) {
                    csvBuilder.append(",");
                }
            }
            csvBuilder.append("\n");
        }
        
        // Возвращаем итоговую строку CSV
        return csvBuilder.toString();
    }

    public static void main(String[] args) {
        // Пример массива заголовков и данных
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
            {"John", "30", "New York"},
            {"Alice", "25", "Los Angeles"},
            {"Bob", "35", "Chicago"}
        };

        // Генерация CSV
        String csv = generateCSV(headers, data);

        // Вывод результата
        System.out.println(csv);
    }
}
