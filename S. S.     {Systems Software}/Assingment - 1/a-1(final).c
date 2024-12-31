#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_LENGTH 100

// Function declarations
int isKeyword(const char* str);
int isIdentifier(const char* str);
int isOperator(const char ch);
int isInteger(const char* str);
void identifyTokens(const char* str);

// List of keywords
const char* keywords[] = {
    "if", "else", "for", "while", "do", "break", "continue", "return",
    "int", "float", "double", "char", "void", "static", "struct",
    "typedef", "switch", "case", "const", NULL
};

int main() {
    char input[MAX_LENGTH];

    printf("Enter a C program string: ");
    fgets(input, MAX_LENGTH, stdin);

    // Remove the trailing newline character
    input[strcspn(input, "\n")] = 0;

    identifyTokens(input);

    return 0;
}

// Function to check if the string is a keyword
int isKeyword(const char* str) {
    int i;
    for ( i = 0; keywords[i] != NULL; i++) {
        if (strcmp(str, keywords[i]) == 0) {
            return 1; // Keyword found
        }
    }
    return 0; // Not a keyword
}

// Function to check if the string is an identifier
int isIdentifier(const char* str) {
    int i;
    if (!isalpha(str[0]) && str[0] != '_') return 0; // Identifiers cannot start with a digit
    for ( i = 1; str[i] != '\0'; i++) {
        if (!isalnum(str[i]) && str[i] != '_') return 0; // Valid characters for identifiers
    }
    return 1; // Valid identifier
}

// Function to check if the character is an operator
int isOperator(const char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
            ch == '=' || ch == '>' || ch == '<' || ch == '!' ||
            ch == '&' || ch == '|');
}

// Function to check if the string is an integer
int isInteger(const char* str) {
    int i;
    for ( i = 0; str[i] != '\0'; i++) {
        if (!isdigit(str[i])) return 0; // Not a valid integer
    }
    return 1; // Valid integer
}

// Function to identify and categorize tokens
void identifyTokens(const char* str) {
    char* token;
    char input[MAX_LENGTH];
    strcpy(input, str); // Copy input to modify for tokenization
    const char* delimiters = " ,;(){}[]\n";

    printf("Tokens identified:\n");

    // Tokenize the input string
    token = strtok(input, delimiters);
    while (token != NULL) {
        if (isKeyword(token)) {
            printf("Keyword: %s\n", token);
        } else if (isIdentifier(token)) {
            printf("Identifier: %s\n", token);
        } else if (isInteger(token)) {
            printf("Integer: %s\n", token);
        } else if (isOperator(token[0]) && strlen(token) == 1) {
            printf("Operator: %c\n", token[0]);
        } else {
            printf("Unknown token: %s\n", token);
        }

        token = strtok(NULL, delimiters);
    }
}
