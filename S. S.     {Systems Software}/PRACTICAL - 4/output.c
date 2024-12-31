
#include <stdio.h>
#include <stdlib.h>

int main() {
    int characters = 0, words = 0, lines = 0, spaces = 0;
    char ch;
    FILE *file;

        char filename[100];
    printf("Enter the file name (with path if necessary): ");
    scanf("%s", filename);

    file = fopen(filename, "r");
    if (file == NULL) {
        printf("Unable to open the file.\n");
        exit(EXIT_FAILURE);
    }

        while ((ch = fgetc(file)) != EOF) {
        characters++; 
        if (ch == ' ') {
            spaces++;         }

        if (ch == '\n') {
            lines++;          }

        if (ch == ' ' || ch == '\n' || ch == '\t') {
            words++;          }
    }

        if (characters > 0) {
        words++;     }

        printf("Total characters = %d\n", characters);
    printf("Total words = %d\n", words);
    printf("Total spaces = %d\n", spaces);
    printf("Total lines = %d\n", lines);

        fclose(file);

    return 0;
}
