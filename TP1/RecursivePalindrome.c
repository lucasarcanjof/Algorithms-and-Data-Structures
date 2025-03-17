#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define TRUE 1
#define FALSE 0
#define INPUT_BREAK "FIM"

bool isPalindrome(char *str, int i, int j) {
    if (i >= j) {
        return TRUE;
    }

    if (str[i] != str[j]) {
        return FALSE;
    }

    return isPalindrome(str, i + 1, j - 1);
}

void processInput() {
    char str[1000];
    fgets(str, sizeof(str), stdin);

    size_t len = strlen(str);
    if (len > 0 && str[len - 1] == '\n') {
        str[len - 1] = '\0';
    }

    if (strcmp(str, INPUT_BREAK) == 0) {
        return;
    }

    if (isPalindrome(str, 0, strlen(str) - 1)) {
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }

    processInput();
}

int main() {
    processInput();
    return 0;
}