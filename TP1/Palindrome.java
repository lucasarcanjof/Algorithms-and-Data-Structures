import java.util.Scanner;
import java.text.Normalizer;

public class Palindrome{

    public static boolean isPalindrome(String str){
        str = Normalizer.normalize(str, Normalizer.Form.NFD);

        int j = str.length() - 1;
        for (int i = 0; i < j ; i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }
    
    public static void main (String[] args) {
        String str = MyIO.readLine();

        while (!isFim(str)) {
            if (isPalindrome(str)){
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
            str = MyIO.readLine();
        }
    }
}