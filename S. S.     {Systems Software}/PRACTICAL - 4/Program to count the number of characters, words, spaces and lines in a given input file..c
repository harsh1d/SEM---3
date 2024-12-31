// Program to count the number of characters, words, spaces and lines in a given input file. USING Lex
#include <stdio.h>

int main(void)
{
  printf("\n HARSH D \n");
  int c, i, j, k, l, n;
  i = j = k = l = n = 0;
  printf("Enter text (Ctrl+D to end input):\n");
  while ((c = getchar()) != EOF)
  {
    ++n;
    if (c == '\n')
      ++l;
    if (c == ' ' || c == '\n')
      ++i;
    if (c == '\t' || c == '\n')
      ++j;
    if (c == '\n')
      ++k;
  }
  printf("Number of characters: %d\n", n);
  printf("Number of words: %d\n", i);
  printf("Number of spaces: %d\n", j);
  printf("Number of lines: %d\n", k);
  return 0;
}
