/**Задача 2. История посещения веб-сайтов
Реализуйте программу для хранения и анализа историй посещений веб-сайтов.
Используйте Deque для хранения истории.
● visitSite(String site): Добавляет сайт в историю посещений.
● back(int steps): Возвращает название сайта, который был посещен
steps назад, или null, если таких шагов нет.
● getHistory(): Возвращает список сайтов в истории посещений, от
последнего посещенного к первому.*/

import java.util.Deque;
import java.util.LinkedList;

public class BrowserHistory {
    
    private Deque<String> history;

    public BrowserHistory() {
        this.history = new LinkedList<>();
    }

    // Добавляет сайт в начало истории посещений
    public void visitSite(String site) {
        history.addFirst(site);
    }

    // Возвращает название сайта, который был посещен steps назад
    public String back(int steps) {
        return history.stream()
                      .skip(steps)
                      .findFirst()
                      .orElse(null);
    }

    // Возвращает весь Deque истории посещений
    public Deque<String> getHistory() {
        return history;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        
        browserHistory.visitSite("www.google.com");
        browserHistory.visitSite("www.youtube.com");
        browserHistory.visitSite("www.github.com");
        
        System.out.println("Текущая история: " + browserHistory.getHistory());
        
        System.out.println("Сайт, посещенный 1 шаг назад: " + browserHistory.back(1));
        System.out.println("Сайт, посещенный 2 шага назад: " + browserHistory.back(2));
        
        System.out.println("Обновленная история: " + browserHistory.getHistory());
    }
}
