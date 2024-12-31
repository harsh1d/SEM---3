#include <stdio.h>
#include <stdlib.h>

int main() {
    int characters = 0, words = 0, lines = 0, spaces = 0;
    char ch;
    FILE *file;

    // Open file, prompt for file name
    char filename[100];
    printf("Enter the file name (with path if necessary): ");
    scanf("%s", filename);

    file = fopen(filename, "r");
    if (file == NULL) {
        printf("Unable to open the file.\n");
        exit(EXIT_FAILURE);
    }

    // Read file character by character
    while ((ch = fgetc(file)) != EOF) {
        characters++; // Increment character count

        if (ch == ' ') {
            spaces++; // Increment space count
        }

        if (ch == '\n') {
            lines++;  // Increment line count
        }

        if (ch == ' ' || ch == '\n' || ch == '\t') {
            words++;  // Increment word count for boundaries
        }
    }

    // Check if the last character read is not a boundary
    if (characters > 0) {
        words++; // Increment for the last word if necessary
    }

    // Print results
    printf("Total characters = %d\n", characters);
    printf("Total words = %d\n", words);
    printf("Total spaces = %d\n", spaces);
    printf("Total lines = %d\n", lines);

    // Close the file
    fclose(file);

    return 0;
}
