// Lex program to Print out all numbers from given file
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main() {
    FILE *file;
    char c;
    int number = 0;
    int inNumber = 0;

    // Attempt to open the file for reading
    file = fopen("text7.txt", "r");

    // Check if the file was opened successfully
    if (file == NULL) {
        printf("Error: Could not open file.\n");
        return 1;
    }

    // Read each character from the file
    while ((c = fgetc(file)) != EOF) {
        // Check if the character is a digit or a sign
        if (isdigit(c)) {
            // If we are still reading a number, build it
            number = number * 10 + (c - '0');
            inNumber = 1;
        } else {
            // If we encounter a non-digit and were in a number, print the number
            if (inNumber) {
                printf("%d\n", number);
                number = 0; // Reset number for the next potential number
                inNumber = 0; // Reset flag
            }
        }
    }

    // Print the last number if the file doesn't end with a non-digit
    if (inNumber) {
        printf("%d\n", number);
    }

    // Close the file
    fclose(file);
    return 0;
}
