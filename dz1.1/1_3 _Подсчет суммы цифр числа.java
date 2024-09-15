/**Задача 3. Подсчет суммы цифр числа
Напишите метод sumDigits, который принимает целое число n и возвращает
сумму его цифр.*/

public class DigitSumCalculator {
    /**
     * Вычисляет сумму цифр числа.
     * 
     * @param n целое число
     * @return сумма цифр числа
     */
    public static int sumDigits(int n) {
        int sum = 0;
        n = Math.abs(n); // Обрабатываем случай отрицательного числа

        while (n > 0) {
            sum += n % 10; // Добавляем последнюю цифру к сумме
            n /= 10; // Убираем последнюю цифру
        }

        return sum;
    }

    public static void main(String[] args) {
        int number = 12345;
        int result = sumDigits(number);
        System.out.println("Сумма цифр числа " + number + " равна " + result);
    }
}

