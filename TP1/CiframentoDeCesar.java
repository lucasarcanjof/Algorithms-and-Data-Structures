import java.util.Scanner;

public class CiframentoDeCesar {

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static String cesarCifra(String palavra) {
        String codigo = "";

        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);

            if (letra <= 127) {
                letra += 3; 
            }

            codigo += letra;
        }

        return codigo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra;

        do {
            palavra = sc.nextLine();

            if (!isFim(palavra)) {
                System.out.println(cesarCifra(palavra));
            }

        } while (!isFim(palavra));

        sc.close();
    }
}
