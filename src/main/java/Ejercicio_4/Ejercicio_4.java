package Ejercicio_4;

public class Ejercicio_4 {
    public static void main(String[] args) {
        int number = 102;
        int sum = sumOfDigits(number);
        System.out.println(sum);
    }

    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }
}
