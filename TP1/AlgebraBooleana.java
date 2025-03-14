import java.util.Stack;

public class AlgebraBooleana{

    public static void main(String[] args) {
        while (true) {
            String entrada = MyIO.readLine();

            if (is0(entrada)) {
                break;
            }

            boolean resultado = avaliarExpressao(entrada);

            MyIO.println(resultado ? "1" : "0");
        }
    }

    public static boolean is0(String str) {
        return str.length() == 1 && str.charAt(0) == '0';
    }

    public static boolean avaliarExpressao(String expressao) {
        String[] partes = expressao.split(" ");
        int n = Integer.parseInt(partes[0]);
        boolean[] entradas = new boolean[n];

        for (int i = 0; i < n; i++) {
            entradas[i] = partes[i + 1].charAt(0) == '1';
        }

        String expr = partes[n + 1];

        return avaliar(expr, entradas);
    }

    public static boolean avaliar(String expr, boolean[] entradas) {
        Stack<Boolean> pilha = new Stack<>();
        int index = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E') {
                pilha.push(entradas[index]);
                index++;
            } else if (c == 'n') {
                boolean valor = pilha.pop();
                pilha.push(!valor);
            } else if (c == 'a') {
                boolean valor2 = pilha.pop();
                boolean valor1 = pilha.pop();
                pilha.push(valor1 && valor2);
            } else if (c == 'o') {
                boolean valor2 = pilha.pop();
                boolean valor1 = pilha.pop();
                pilha.push(valor1 || valor2);
            }
        }

        return pilha.pop();
    }
}