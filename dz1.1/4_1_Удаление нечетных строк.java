/**Задание 1. Удаление нечетных строк
Дан LinkedList с несколькими элементами. В методе
removeOddLengthStrings класса LLTasks реализуйте удаление строк, длина
которых нечетная. Используйте LinkedList и стандартные методы.*/
import java.util.LinkedList;

class LLTasks {
    public static void removeOddLengthStrings(LinkedList<String> ll) {
        LinkedList<String> toRemove = new LinkedList<>();
        for (String s : ll) {
            if (s.length() % 2 != 0) {
                toRemove.add(s);
            }
        }
        ll.removeAll(toRemove);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        
        if (args.length == 0) {
            // При отправке кода на выполнение, вы можете варьировать эти параметры
            ll.add("apple");
            ll.add("banana");
            ll.add("pear");
            ll.add("grape");
        } else {
            for (String arg : args) {
                ll.add(arg);
            }
        }
        
        LLTasks answer = new LLTasks();
        System.out.println("Before: " + ll);
        answer.removeOddLengthStrings(ll);
        System.out.println("After: " + ll);
    }
}
