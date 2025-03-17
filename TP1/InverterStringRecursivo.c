#include <stdio.h>
#include <string.h>

void inverterStringRecursivo(char *str, int inicio, int fim) {
    if (inicio >= fim) {
        return;
    }
    char temp = str[inicio];
    str[inicio] = str[fim];
    str[fim] = temp;
    inverterStringRecursivo(str, inicio + 1, fim - 1);
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
        
        inverterStringRecursivo(entrada, 0, strlen(entrada) - 1);
        printf("%s\n", entrada);
    }
    
    return 0;
}
