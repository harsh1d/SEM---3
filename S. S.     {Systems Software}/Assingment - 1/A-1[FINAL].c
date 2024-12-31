#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define MAX_LENGTH 100

// Function declarations
bool isKeyword(char* str);
bool isIdentifier(char* str);
bool isOperator(char ch);
bool isInteger(char* str);
void identifyTokens(char* str);

const char* keywords[] = {
    "if", "else", "for", "while", "do", "break", "continue", "int",
    "float", "double", "char", "return", "void", "static", "struct",
    "typedef", "switch", "case", "const", NULL
};

int main() {
    char input[MAX_LENGTH];

    printf("Enter a C program string: ");
    fgets(input, MAX_LENGTH, stdin);

    // Remove trailing newline character
    input[strcspn(input, "\n")] = 0;

    identifyTokens(input);

    return 0;
}

// Function to check if the string is a keyword
bool isKeyword(char* str) {
    int i;
    for ( i = 0; keywords[i] != NULL; i++) {
        if (strcmp(str, keywords[i]) == 0) {
            return true;
        }
    }
    return false;
}

// Function to check if the string is a valid identifier
bool isIdentifier(char* str) {
    if (!isalpha(str[0])) return false;
    int i;  // Identifiers cannot start with a digit
    for ( i = 1; str[i] != '\0'; i++) {
        if (!isalnum(str[i]) && str[i] != '_') return false;  // Valid characters
    }
    return true;
}

// Function to check if the character is an operator
bool isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
            ch == '=' || ch == '>' || ch == '<' || ch == '!' ||
            ch == '&' || ch == '|');
}

// Function to check if the string is an integer
bool isInteger(char* str) {
    int i;
    for ( i = 0; str[i] != '\0'; i++) {
        if (!isdigit(str[i])) return false;
    }
    return true;
}

// Function to identify and categorize tokens
void identifyTokens(char* str) {
    char* token;
    const char* delimiters = " ,;(){}\n";

    printf("Tokens identified:\n");

    // Tokenize the input string
    token = strtok(str, delimiters);
    while (token != NULL) {
        if (isKeyword(token)) {
            printf("Keyword: %s\n", token);
        } else if (isIdentifier(token)) {
            printf("Identifier: %s\n", token);
        } else if (isInteger(token)) {
            printf("Integer: %s\n", token);
        } else if (isOperator(token[0])) {
            printf("Operator: %c\n", token[0]);
        } else {
            printf("Unknown: %s\n", token);
        }

        token = strtok(NULL, delimiters);
    }
}
