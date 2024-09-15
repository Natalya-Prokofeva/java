/**Задание 1. Формирование URL с параметрами
Дана строка базового URL:
https://example.com/search?
Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
передаются в виде строки, где ключи и значения разделены =, а пары
ключ-значение разделены &. Если значение null, то параметр не должен
попадать в URL.
Пример:
params = "query=java&sort=desc&filter=null"
Результат:
https://example.com/search?query=java&sort=desc*/

import java.util.HashMap;
import java.util.Map;

public class URLBuilder {

    public static String buildURLWithParams(String baseURL, String params) {
        try {
            // Разделяем параметры на ключ-значение пары
            String[] pairs = params.split("&");

            // Используем Map для хранения ключ-значение пар
            Map<String, String> paramMap = new HashMap<>();

            for (String pair : pairs) {
                // Разделяем ключ и значение
                String[] keyValue = pair.split("=");

                if (keyValue.length == 2 && !"null".equals(keyValue[1])) {
                    paramMap.put(keyValue[0], keyValue[1]);
                }
            }

            StringBuilder fullURL = new StringBuilder(baseURL);
            if (!paramMap.isEmpty()) {
                fullURL.append("?");
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    fullURL.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                // Удаляем последний символ &
                fullURL.deleteCharAt(fullURL.length() - 1);
            }

            return fullURL.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String baseURL = "https://example.com";
        String params = "param1=value1&param2=null&param3=value3";

        String fullURL = buildURLWithParams(baseURL, params);
        System.out.println(fullURL);  // Вывод: https://example.com?param1=value1&param3=value3
    }
}
