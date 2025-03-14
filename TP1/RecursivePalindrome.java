import java.text.Normalizer;

public class RecursivePalindrome{
    static final String inputBreak = "FIM";

    public static boolean isPalindrome(String str, int i, int j) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);

        if (i >= j) {
            return true;
        }

        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }

        return isPalindrome(str, i + 1, j - 1);
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        String str = MyIO.readLine();
        processInput(str);
    }

    public static void processInput(String str) {
        if (isFim(str)) {
            return;
        }

        if (isPalindrome(str, 0, str.length() - 1)) {
            MyIO.println("SIM");
        } else {
            MyIO.println("NAO");
        }

        processInput(MyIO.readLine());
    }
}