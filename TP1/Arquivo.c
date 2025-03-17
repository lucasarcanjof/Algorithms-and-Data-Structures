#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

      FILE *file = fopen("valores.dat", "wb");

      for (int i = 0; i < n; i++) {
        double num;
        scanf("%lf", &num);
        fwrite(&num, sizeof(double), 1, file);
    }

    fclose(file);

       file = fopen("valores.dat", "rb");

    fseek(file, 0, SEEK_END);
    long pointer = ftell(file);

    for (int i = 0; i < n; i++) {
        pointer -= sizeof(double);
        fseek(file, pointer, SEEK_SET);

        double value;
        fread(&value, sizeof(double), 1, file);

        if (value == (int)value) {
            printf("%.0f\n", value);
        } else {
            printf("%.3f\n", value);
        }
    }

    fclose(file);

    return 0;
}
