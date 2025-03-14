import java.util.Scanner;

public class RecursiveCiframento {

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static String cesarCifra(String palavra, int index) {
        if (index >= palavra.length()) {
            return "";
        }

        char letra = palavra.charAt(index);

        if (letra <= 127) {
            letra += 3;
        }

        return letra + cesarCifra(palavra, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra;

        do {
            palavra = sc.nextLine();

            if (!isFim(palavra)) {
                System.out.println(cesarCifra(palavra, 0));
            }

        } while (!isFim(palavra));

        sc.close();
    }
}