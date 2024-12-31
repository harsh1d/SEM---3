// Write a C program to identify whether a given line is a comment or not.
#include <stdio.h>

int main(void) {
  char line[100];
  printf("Enter a line: ");
  scanf("%[^\n]s", line);
  if(line[0] == '/'){
    if(line[1] == '/')
    {
      printf("It is a comment");
    }
    else if(line[1] == '*')
    {
      printf("It is a comment");
    }
    else
    {
      printf("It is not a comment");
    }
  }
  else
  {
    printf("It is not a comment");
  }
  return 0;
}
