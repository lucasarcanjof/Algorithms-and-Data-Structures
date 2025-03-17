public class Anagrama {

    public static boolean isFim(String str) {
        return str.length() == 3 &&
               str.charAt(0) == 'F' &&
               str.charAt(1) == 'I' &&
               str.charAt(2) == 'M';
    }

    public static boolean saoAnagramas(String str1, String str2) {
        str1 = str1.replaceAll("[\\s-]", "").toLowerCase();
        str2 = str2.replaceAll("[\\s-]", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] contagem1 = new int[256];
        int[] contagem2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            contagem1[str1.charAt(i)]++;
            contagem2[str2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (contagem1[i] != contagem2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        while (true) {
            String line = MyIO.readLine();
            
            if (isFim(line)) {
                break;
            }

            String[] parts = line.split("-");
            String str1 = parts[0].trim();
            String str2 = parts[1].trim();

            if (saoAnagramas(str1, str2)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NÃO");
            }
        }
    }
}
