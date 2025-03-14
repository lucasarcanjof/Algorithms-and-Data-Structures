import java.text.Normalizer;

public class ls{
    public static String removeInvalidCharacters(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static boolean isOnlyVowels(String str) {
        str = removeInvalidCharacters(str);
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (vowels.indexOf(c) == -1 && c != ' ') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isOnlyConsonants(String str) {
        str = removeInvalidCharacters(str);
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if ((!(c >= 'a' && c <= 'z') || vowels.indexOf(c) != -1) && c != ' ' && c != '-') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isInteger(String str) {
        if (str.length() == 0) return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= '0' && c <= '9') && !(i == 0 && c == '-')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRealNumber(String str) {
        if (str.length() == 0) return false;
        boolean hasDecimalPoint = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.' || c == ',') {
                if (hasDecimalPoint) return false;
                hasDecimalPoint = true;
            } else if (!(c >= '0' && c <= '9') && !(i == 0 && c == '-')) {
                return false;
            }
        }
        return hasDecimalPoint;
    }

    public static void main(String[] args) {
        String input;
        while (!(input = MyIO.readLine()).equals("FIM")) {
            MyIO.println(
                (isOnlyVowels(input) ? "SIM" : "NAO") + " " +
                (isOnlyConsonants(input) ? "SIM" : "NAO") + " " +
                (isInteger(input) ? "SIM" : "NAO") + " " +
                (isRealNumber(input) ? "SIM" : "NAO")
            );
        }
    }
}
