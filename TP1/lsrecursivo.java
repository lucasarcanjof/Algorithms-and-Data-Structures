import java.text.Normalizer;

public class lsrecursivo {
    public static String removeInvalidCharacters(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public static boolean isFim(String str) {
        return str.length() == 3 
        && str.charAt(0) == 'F' 
        && str.charAt(1) == 'I' 
        && str.charAt(2) == 'M';
    }

    public static boolean isOnlyVowels(String str) {
        return isOnlyVowelsHelper(removeInvalidCharacters(str), 0);
    }
    
    private static boolean isOnlyVowelsHelper(String str, int i) {
        if (i == str.length()) return str.length() > 0;
        char c = Character.toLowerCase(str.charAt(i));
        String vowels = "aeiou";
        if (vowels.indexOf(c) == -1 && c != ' ') return false;
        return isOnlyVowelsHelper(str, i + 1);
    }

    public static boolean isOnlyConsonants(String str) {
        return isOnlyConsonantsHelper(removeInvalidCharacters(str), 0);
    }
    
    private static boolean isOnlyConsonantsHelper(String str, int i) {
        if (i == str.length()) return str.length() > 0;
        char c = Character.toLowerCase(str.charAt(i));
        String vowels = "aeiou";
        if ((!(c >= 'a' && c <= 'z') || vowels.indexOf(c) != -1) && c != ' ' && c != '-') return false;
        return isOnlyConsonantsHelper(str, i + 1);
    }

    public static boolean isInteger(String str) {
        return isIntegerHelper(str, 0, str.length() > 0);
    }
    
    private static boolean isIntegerHelper(String str, int i, boolean valid) {
        if (i == str.length()) return valid;
        char c = str.charAt(i);
        if (!(c >= '0' && c <= '9') && !(i == 0 && c == '-')) return false;
        return isIntegerHelper(str, i + 1, valid);
    }

    public static boolean isRealNumber(String str) {
        return isRealNumberHelper(str, 0, false, str.length() > 0);
    }
    
    private static boolean isRealNumberHelper(String str, int i, boolean hasDecimalPoint, boolean valid) {
        if (i == str.length()) return hasDecimalPoint && valid;
        char c = str.charAt(i);
        if (c == '.' || c == ',') {
            if (hasDecimalPoint) return false;
            hasDecimalPoint = true;
        } else if (!(c >= '0' && c <= '9') && !(i == 0 && c == '-')) {
            return false;
        }
        return isRealNumberHelper(str, i + 1, hasDecimalPoint, valid);
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
