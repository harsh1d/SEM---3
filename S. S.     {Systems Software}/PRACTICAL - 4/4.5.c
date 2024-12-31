  #include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
  #include <ctype.h>

  #define MAX_WORD_LEN 100
  #define MAX_LINE_LEN 256

  // Function to check if a word is a valid identifier
  int is_identifier(const char *word) {
      if (!isalpha(word[0]) && word[0] != '_') {  // First character must be a letter or underscore
          return 0; // Not a valid identifier
      }
      int i;
      for (i = 1; word[i] != '\0'; i++) {    // Check subsequent characters
          if (!isalnum(word[i]) && word[i] != '_') {
              return 0; // Contains invalid characters
          }
      }
      return 1; // Valid identifier
  }

  // Function to count identifiers in a file
  int count_identifiers(const char *file_name) {
      FILE *file = fopen(file_name, "r");
      if (file == NULL) {
          perror("Error opening file");
          return -1; // Error opening file
      }

      char line[MAX_LINE_LEN];
      char word[MAX_WORD_LEN];
      int count = 0;

      // Read lines from file
      while (fgets(line, sizeof(line), file)) {
          char *token = strtok(line, " \t\n"); // Split line into words
          while (token != NULL) {
              if (is_identifier(token)) {
                  printf("%s is an identifier\n", token);
                  count++;
              } else if (isdigit(token[0]) || (token[0] == '-' && isdigit(token[1]))) {
                  printf("%s is a number\n", token);
              }
              token = strtok(NULL, " \t\n"); // Get next token
          }
      }

      fclose(file); // Close the file
      return count; // Return total count of identifiers
  }

  int main() {
      char file_name[100];
      printf("Enter the filename: ");
      fgets(file_name, sizeof(file_name), stdin); // Read the filename from input
      file_name[strcspn(file_name, "\n")] = '\0'; // Remove the newline character

      int total_identifiers = count_identifiers(file_name);
      if (total_identifiers >= 0) {
          printf("Total identifiers are: %d\n", total_identifiers); // Print total identifiers
      }

      return 0;
  }
