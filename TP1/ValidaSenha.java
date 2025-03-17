import java.util.Scanner;

public class ValidaSenha{

    public static boolean isSenhaValida(String senha) {
        if (senha.length() < 8) {
            return false;
        }

        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);

            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            } else if (Character.isLowerCase(c)) {
                temMinuscula = true;
            } else if (Character.isDigit(c)) {
                temNumero = true;
            } else {
                temEspecial = true;
            }
        }

        return temMaiuscula && temMinuscula && temNumero && temEspecial;
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (isFim(entrada)) {
                break;
            }

            if (isSenhaValida(entrada)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }

        sc.close();
    }
}
