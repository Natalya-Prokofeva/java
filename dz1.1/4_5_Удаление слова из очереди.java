/**Задача 5*. Удаление слова из очереди
Реализуйте метод removeAllOccurrences в классе DequeTasks, который
принимает Deque<String> и строку value. Метод должен удалить все
вхождения строки value из очереди.*/

import java.util.Deque;
import java.util.LinkedList;
class DequeTasks {
public static void removeAllOccurrences(Deque<String>
deque, String value) {
// Напишите свое решение ниже
}
}
// Не удаляйте этот класс - он нужен для вывода результатов на
экран и проверки
public class Printer {
public static void main(String[] args) {
Deque<String> deque = new LinkedList<>();
String value;
if (args.length < 2) {
// При отправке кода на Выполнение, вы можете
варьировать эти параметры
deque.add("apple");
deque.add("banana");
deque.add("apple");
deque.add("cherry");
value = "apple";
} else {
for (int i = 0; i < args.length - 1; i++) {
deque.add(args[i]);
}
value = args[args.length - 1];
}
DequeTasks.removeAllOccurrences(deque, value);
}
}
