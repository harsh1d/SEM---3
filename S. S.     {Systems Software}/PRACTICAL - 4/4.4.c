#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
  char sentence[1000];
  char *token;
  int isCompound = 0;

  // Get the sentence from the user
  printf("Enter a sentence: ");
  fgets(sentence, sizeof(sentence), stdin);

  // Remove trailing newline character
  sentence[strcspn(sentence, "\n")] = 0;

  // Tokenize the sentence based on spaces
  token = strtok(sentence, " ");

  while (token != NULL) {
    // Check for common conjunctions (and, but, or, so, for, nor, yet)
    if (strcmp(token, "and") == 0 || strcmp(token, "but") == 0 ||
        strcmp(token, "or") == 0 || strcmp(token, "so") == 0 ||
        strcmp(token, "for") == 0 || strcmp(token, "nor") == 0 ||
        strcmp(token, "yet") == 0) {
      isCompound = 1;
      break;
    }

    token = strtok(NULL, " ");
  }

  // Print the result
  if (isCompound) {
    printf("The sentence is compound.\n");
  } else {
    printf("The sentence is simple.\n");
  }

  return 0;
}
