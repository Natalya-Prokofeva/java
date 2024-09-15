/**Задача 2. Реализация стека
Реализуйте MyStack с использованием LinkedList с методами:
● push(String element) - добавляет элемент на вершину стека
● pop() - возвращает элемент с вершины и удаляет его
● peek() - возвращает элемент с вершины, не удаляя
● getElements() - возвращает все элементы стека*/

import java.util.LinkedList;

public class MyStack {
    private LinkedList<String> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }

    // Метод для добавления элемента на вершину стека
    public void push(String element) {
        stack.addFirst(element);
    }

    // Метод для удаления и возврата элемента с вершины стека
    public String pop() {
        return stack.isEmpty() ? null : stack.removeFirst();
    }

    // Метод для возвращения элемента с вершины стека без удаления
    public String peek() {
        return stack.isEmpty() ? null : stack.peekFirst();
    }

    // Метод для возврата всех элементов стека
    public LinkedList<String> getElements() {
        return new LinkedList<>(stack);
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("apple");
        myStack.push("banana");
        myStack.push("pear");
        myStack.push("grape");

        System.out.println("Stack elements: " + myStack.getElements());
        System.out.println("Peek: " + myStack.peek());
        System.out.println("Pop: " + myStack.pop());
        System.out.println("After pop, stack elements: " + myStack.getElements());
    }
}
