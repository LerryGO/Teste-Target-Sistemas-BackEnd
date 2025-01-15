import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        scanner.close();

        boolean pertence = pertenceFibonacci(numero);
        System.out.println("O número " + numero + (pertence ? " pertence" : " não pertence") + " à sequência de Fibonacci.");
    }

    public static boolean pertenceFibonacci(int numero) {
        int a = 0, b = 1;
        while (a <= numero) {
            if (a == numero) return true;
            int temp = a;
            a = b;
            b = temp + b;
        }
        return false;
    }
}

