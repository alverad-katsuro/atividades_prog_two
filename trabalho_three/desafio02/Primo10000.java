/*Escreva um programa para listar todos os números primos entre 1 e 10000*/
public class Primo10000 {
    public static boolean isPrimeNumber(int x) {
        for (int n = 2; n < x; n++) {
            if ((x % n) == 0) {
                return false;
            }
        }
        if (x == 1) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            if (isPrimeNumber(i)) {
                 System.out.printf("%d; ", i);
            }
        }
    }
}