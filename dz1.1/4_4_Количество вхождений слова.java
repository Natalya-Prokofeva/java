/**Задача 4. Сдвиг очереди
Реализуйте метод rotateDeque в классе DequeTasks, который принимает
Deque<Integer> и число n. Метод должен повернуть очередь вправо на n
позиций. Если n отрицательное, повернуть влево.*/
import java.util.Deque;
import java.util.LinkedList;

public class DequeTasks {
    public static void rotateDeque(Deque<Integer> deque, int n) {
        if (deque == null || deque.isEmpty()) {
            return; // Нечего вращать
        }
        
        int size = deque.size();
        n = n % size; // Уменьшение n до размера очереди

        if (n < 0) {
            n += size; // Преобразование отрицательного n в эквивалентное положительное значение
        }

        for (int i = 0; i < n; i++) {
            Integer element = deque.removeLast();
            deque.addFirst(element);
        }
    }
    
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        System.out.println("Original deque: " + deque);
        
        rotateDeque(deque, 2);
        System.out.println("Deque after rotating right by 2: " + deque);

        rotateDeque(deque, -3);
        System.out.println("Deque after rotating left by 3: " + deque);
    }
}
