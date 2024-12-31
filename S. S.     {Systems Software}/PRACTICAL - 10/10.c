// Write a C program to parse a given string using Predictive parsing for given
// grammar.Type→ simple |↑id |array[ simple] of type simple→integer |char |num dot
// dot num


#include <stdio.h>
#include <string.h>
#include <ctype.h>

int parseType(const char *str, int *index);
int parseSimple(const char *str, int *index);

int parseType(const char *str, int *index) {
    if (strncmp(&str[*index], "simple", 6) == 0) {
        *index += 6;
        return 1;
    } else if (strncmp(&str[*index], "↑id", 3) == 0) {
        *index += 3;
        return 1;
    } else if (strncmp(&str[*index], "array[", 6) == 0) {
        *index += 6;
        if (parseSimple(str, index)) {
            if (strncmp(&str[*index], "] of type ", 10) == 0) {
                *index += 10;
                if (parseType(str, index)) {
                    return 1;
                }
            }
        }
    }
    return 0;
}

int parseSimple(const char *str, int *index) {
    if (strncmp(&str[*index], "integer", 7) == 0) {
        *index += 7;
        return 1;
    } else if (strncmp(&str[*index], "char", 4) == 0) {
        *index += 4;
        return 1;
    } else if (isdigit(str[*index])) {
        while (isdigit(str[*index])) {
            (*index)++;
        }
        if (strncmp(&str[*index], " dot dot ", 9) == 0) {
            *index += 9;
            if (isdigit(str[*index])) {
                while (isdigit(str[*index])) {
                    (*index)++;
                }
                return 1;
            }
        }
    }
    return 0;
}

int main() {
    char input[256];
    printf("Enter the string to parse: ");
    fgets(input, 256, stdin);
    input[strcspn(input, "\n")] = '\0';

    int index = 0;
    if (parseType(input, &index) && input[index] == '\0') {
        printf("The string is valid according to the grammar.\n");
    } else {
        printf("The string is invalid according to the grammar.\n");
    }

    return 0;
}

