public class FactorialCalculator {
    /**
     * Вычисляет факториал числа n.
     * @param n число, для которого вычисляется факториал
     * @return факториал числа n или -1, если n < 0
     */
    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5;
        long result = factorial(number);
        if (result != -1) {
            System.out.println("Факториал числа " + number + " равен " + result);
        } else {
            System.out.println("Факториал не определен для отрицательных чисел.");
        }
    }
}
