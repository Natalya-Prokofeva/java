/**Задание 1. Студенческий справочник
Реализуйте программу для работы с простым справочником студентов.
Программа должна иметь следующие функции:
● addStudent(String name, Integer grade): Добавляет или
обновляет запись о студенте с именем name и оценкой grade. Если
студент уже существует, обновляет его оценку.
● findStudent(String name): Находит оценки студента по его имени.
Если студент существует, возвращает список его оценок. Если нет —
пустой список.
● getAllStudents(): Возвращает весь справочник студентов в виде
HashMap, где ключи — имена студентов, а значения — списки их оценок.
● removeStudent(String name): Удаляет запись о студенте по имени
из справочника. Если запись не существует, ничего не происходит.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDirectory {

    private Map<String, List<Integer>> directory;

    public StudentDirectory() {
        this.directory = new HashMap<>();
    }

    // Добавляет или обновляет запись о студенте
    public void addStudent(String name, Integer grade) {
        directory.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
    }

    // Ищет оценки студента по имени
    public List<Integer> findStudent(String name) {
        return directory.getOrDefault(name, new ArrayList<>());
    }

    // Возвращает весь справочник
    public Map<String, List<Integer>> getAllStudents() {
        return new HashMap<>(directory);
    }

    // Удаляет запись о студенте по имени
    public void removeStudent(String name) {
        directory.remove(name);
    }

    // Демонстрация работы программы
    public static void main(String[] args) {
        StudentDirectory sd = new StudentDirectory();
        
        sd.addStudent("Иван", 85);
        sd.addStudent("Иван", 90);
        sd.addStudent("Анна", 95);
        
        System.out.println("Оценки Ивана: " + sd.findStudent("Иван"));
        System.out.println("Оценки Анны: " + sd.findStudent("Анна"));
        System.out.println("Оценки Петра (не добавлен): " + sd.findStudent("Петр"));
        
        System.out.println("Справочник всех студентов: " + sd.getAllStudents());
        
        sd.removeStudent("Иван");
        System.out.println("Справочник после удаления Ивана: " + sd.getAllStudents());
    }
}
