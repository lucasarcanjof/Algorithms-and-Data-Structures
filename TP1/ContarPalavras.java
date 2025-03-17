import java.util.Scanner;

public class ContarPalavras {
    public static int contarPalavras(String str) {
        int contador = 0;
        boolean dentroPalavra = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (!dentroPalavra) {
                    contador++;
                    dentroPalavra = true;
                }
            } else {
                dentroPalavra = false;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equals("FIM")) {
                break;
            }

            System.out.println(contarPalavras(entrada));
        }

        sc.close();
    }
}
