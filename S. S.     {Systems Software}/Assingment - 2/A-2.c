#include <stdio.h>
#include <string.h>

int main() {
    char operation[10];
    int num1, num2, result;

    // Get the operation and numbers from the user
    printf("Enter operation (ADD, SUB, etc.) and two numbers separated by spaces: ");
    scanf("%s %d %d", operation, &num1, &num2);

    // Perform the operation based on the input
    if (strcmp(operation, "ADD") == 0) {
        result = num1 + num2;
    } else if (strcmp(operation, "SUB") == 0) {
        result = num1 - num2;
    } else if (strcmp(operation, "MUL") == 0) {
        result = num1 * num2;
    } else if (strcmp(operation, "DIV") == 0) {
        if (num2 == 0) {
            printf("Error: Division by zero.\n");
            return 1; // Indicate an error
        }
        result = num1 / num2;
    } else {
        printf("Invalid operation.\n");
        return 1; // Indicate an error
    }

    // Print the result
    printf("Result: %d\n", result);

    return 0;
}
