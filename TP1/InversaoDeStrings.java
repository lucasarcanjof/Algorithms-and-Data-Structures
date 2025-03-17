public class InversaoDeStrings {

    public static String InversaoDeStrings(String s) {
        char[] caracteres = s.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;
            inicio++;
            fim--;
        }

        return new String(caracteres);
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        String entrada;

        while (true) {
            entrada = MyIO.readLine();

            if (isFim(entrada)) {
                break;
            }

            String saida = InversaoDeStrings(entrada);
            MyIO.println(saida);
        }
    }
}