#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
  char expression[100];
  char token[100];
  int i = 0, j = 0, isIdentifier = 0, isOperator = 0, isValid = 1;

  // Get the arithmetic expression from the user
  printf("Enter an arithmetic expression: ");
  scanf("%s", expression);

  // Tokenize the expression
  while (expression[i] != '\0') {
    if (isalnum(expression[i]) || expression[i] == '_') {
      // If it's a letter, digit, or underscore, it's part of an identifier
      token[j] = expression[i];
      isIdentifier = 1;
      isOperator = 0;
    } else {
      // If it's an operator, reset the token and set the flag
      if (isIdentifier) {
        token[j] = '\0';
        printf("Identifier: %s\n", token);
        j = 0;
        isIdentifier = 0;
      }
      if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/' || expression[i] == '(' || expression[i] == ')') {
        token[j] = expression[i];
        token[j + 1] = '\0';
        printf("Operator: %s\n", token);
        isOperator = 1;
      } else {
        // Invalid character, mark expression as invalid
        isValid = 0;
        break;
      }
      j = 0;
    }
    i++;
    j++;
  }

  // Handle the last token
  if (isIdentifier) {
    token[j] = '\0';
    printf("Identifier: %s\n", token);
  }

  // Print the validation result
  if (isValid) {
    printf("Expression is valid.\n");
  } else {
    printf("Expression is invalid.\n");
  }

  return 0;
}
