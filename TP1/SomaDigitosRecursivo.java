import java.util.Scanner;

public class SomaDigitosRecursivo {
    public static int somaDigitos(int numero) {
        if (numero < 10) {
            return numero;
        }
        return (numero % 10) + somaDigitos(numero / 10);
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String entrada = sc.next();

            if (isFim(entrada)) {
                break;
            }

            int numero = Integer.parseInt(entrada);
            int resultado = somaDigitos(numero);
            System.out.println(resultado);
        }

        sc.close();
    }
}
