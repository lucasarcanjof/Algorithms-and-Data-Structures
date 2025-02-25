import java.util.Scanner;
import java.text.Normalizer;

public class Palindromo{
    static final String inputBreak = "FIM";

    public static boolean isPalindrom(String str){
        str = Normalizer.normalize(str, Normalizer.Form.NFD);

        int j = str.length() - 1;
        for (int i = 0; i < j ; i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
    
    public static void main (String[] args) {
        String str = MyIO.readLine();

        while(!str.equals(inputBreak)) {
            if (isPalindromo(str)){
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
            str = MyIO.readLine();
        }
    }
}
