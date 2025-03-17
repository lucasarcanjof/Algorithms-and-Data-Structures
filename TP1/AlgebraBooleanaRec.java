public class AlgebraBooleanaRec {
    public static String calcular(String str, int n) {
        String resp = "";
        int inicio = 0, fim = 0;

        if (n > 1) {

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    inicio = i;
                } else if (str.charAt(i) == ')') {
                    fim = i;
                    i = str.length();
                }
            }

            if (str.charAt(inicio - 1) == 't') { 
                resp = new String();

                for (int i = 0; i < str.length(); i++) {
                    if (i == (inicio - 3)) {
                        if (str.charAt(inicio + 1) == '0') {
                            resp += '1';
                        } else {
                            resp += '0';
                        }
                    } else if (i > (inicio - 3) && i <= fim) {
                        resp += "";
                    } else {
                        resp += str.charAt(i);
                    }
                }

            } else if (str.charAt(inicio - 1) == 'd') { 
                resp = new String();

                for (int i = 0; i < str.length(); i++) {

                    if (i == (inicio - 3)) {

                        if (str.charAt(inicio + 1) == '1'
                                && str.charAt(inicio + 3) == '1'
                                && str.charAt(fim - 1) == '1') {
                            resp += '1';
                        } else {
                            resp += '0';
                        }
                    } else if (i > (inicio - 3) && i <= fim) {
                        resp += "";
                    } else {
                        resp += str.charAt(i);
                    }

                }
            } else if (str.charAt(inicio - 1) == 'r') { 
                resp = new String();

                for (int i = 0; i < str.length(); i++) {

                    if (i == (inicio - 2)) {
                        if (str.charAt(inicio + 1) == '1'
                                || str.charAt(inicio + 3) == '1'
                                || str.charAt(fim - 1) == '1' || str.charAt(fim - 3) == '1') {
                            resp += '1';
                        } else {
                            resp += '0';
                        }
                    } else if (i > (inicio - 2) && i <= fim) {
                        resp += "";
                    } else {
                        resp += str.charAt(i);
                    }
                }
            }

            resp = resp.replaceAll(" ", "");
            str = calcular(resp,resp.length());
        } 

        return str;
    }

    public static void main(String[] args) {
        String str = MyIO.readLine().replaceAll(" ", "");

        while (str.charAt(0) != '0') {
            String bool = " ";

            char A = str.charAt(1);
            char B = str.charAt(2);
            char C = (str.charAt(0) == '3') ? str.charAt(3) : '*';

            if (str.charAt(0) == '3') {
                for (int i = 4; i < str.length(); i++) {
                    if (str.charAt(i) == 'A') {
                        bool += A;
                    } else if (str.charAt(i) == 'B') {
                        bool += B;
                    } else if (str.charAt(i) == 'C') {
                        bool += C;
                    } else {
                        bool += str.charAt(i);
                    }
                }
            } else {
                for (int i = 3; i < str.length(); i++) {
                    if (str.charAt(i) == 'A') {
                        bool += A;
                    } else if (str.charAt(i) == 'B') {
                        bool += B;
                    } else {
                        bool += str.charAt(i);
                    }
                }
            }

            System.out.println(calcular(bool, bool.length()));
        
            str = MyIO.readLine().replaceAll(" ", "");
        }

    }
}
