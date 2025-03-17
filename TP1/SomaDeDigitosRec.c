#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int somaDigitos(int numero) {
    if (numero < 10) {
        return numero;
    }
    return (numero % 10) + somaDigitos(numero / 10);
}

int isFim(char *str) {
    return (strlen(str) == 3 
    && str[0] == 'F' 
    && str[1] == 'I' 
    && str[2] == 'M');
}

int main() {
    char entrada[100];
    
    while (scanf("%s", entrada) != EOF) {
        if (isFim(entrada)) {
            break;
        }
        
        int numero = atoi(entrada);
        int resultado = somaDigitos(numero);
        printf("%d\n", resultado);
    }
    
    return 0;
}
