// Write a C program to identify whether a given line is a comment or not. and give out put that it is multiline or not
#include <stdio.h>

int main(void)
{
  char line[100];
  printf("Enter a line: ");
  scanf("%[^\n]s", line);
  if (line[0] == '/' && line[1] == '/')
  {
    printf("It is a single line comment");
  }
  else
  {
    if (line[0] == '/' && line[1] == '*')
    {
      printf("It is a multiline comment");
    }
    else
    {
      printf("It is not a comment");
    }
  }
  return 0;
}
