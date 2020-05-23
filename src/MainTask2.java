import java.util.Arrays;

// Данный способ вычисления числа Фибоначи работает за время O(n) т.к. проход в одном цикле
public class MainTask2 {
    public static void main(String[] args) {
        System.out.println("res = "+fib(10));
    }

    public static int fib(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n+1; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}
