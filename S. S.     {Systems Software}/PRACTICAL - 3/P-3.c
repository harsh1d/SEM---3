// Write a C program to simulate lexical analyzer for validating operators
#include <stdio.h>

int main()
{
  char c;
  printf("Enter a character: ");
  scanf("%c", &c);
  if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
  {
    printf("It is an operator");
  }
  else
  {
    printf("It is not an operator");
  }
  return 0;
}
