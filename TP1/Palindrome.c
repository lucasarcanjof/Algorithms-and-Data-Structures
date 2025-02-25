#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define INPUT_BREAK "FIM"
#define TRUE 1
#define FALSE 0

bool isPalindrome(char *str){
    int j = strlen(str) - 1;
    if (str[j] == '\n') {
        str[j] = '\0';
        j--;
    }
    for (int i = 0; i < j ; i++, j--){
        if (str[i] != str[j]){
            return FALSE;
        }
    }
    return TRUE;
}

int main(){
    char str[50];
    fgets(str, sizeof(str), stdin);

    while (strcmp(INPUT_BREAK, str)){
        if (isPalindrome(str)){
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
        fgets(str, sizeof(str), stdin);
    }
    return 0;
}