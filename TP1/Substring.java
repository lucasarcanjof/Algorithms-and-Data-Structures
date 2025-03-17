import java.util.Scanner;

public class Substring {

    public static int comprimentoSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        int[] charIndex = new int[256];  

        for (int end = 0; end < n; end++) {
            start = Math.max(start, charIndex[str.charAt(end)]);  

            maxLength = Math.max(maxLength, end - start + 1);  

            charIndex[str.charAt(end)] = end + 1;  
        }

        return maxLength;
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
            System.out.println(comprimentoSubstring(entrada));
        }

        sc.close();
    }
}
