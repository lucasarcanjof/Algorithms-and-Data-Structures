import java.util.Random;

public class SubstituirLetras {

    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);

        while (true) {
            String entrada = MyIO.readLine();

            if (isFim(entrada)) {
                break;
            }

            char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            String resultado = substituirLetras(entrada, letra1, letra2);

            MyIO.println(resultado);
        }
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static String substituirLetras(String str, char letra1, char letra2) {
        String resultado = "";
        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);
            if (caractere == letra1) {
                resultado += letra2;
            } else {
                resultado += caractere;
            }
        }
        return resultado;
    }
}