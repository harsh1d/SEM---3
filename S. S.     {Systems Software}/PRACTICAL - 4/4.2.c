#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

void count_and_eliminate_comments(const char *input_file, const char *output_file) {
    FILE *source_file, *dest_file;
    char line[MAX_LINE_LENGTH];
    int comment_count = 0;

    // Open the source file for reading
    source_file = fopen(input_file, "r");
    if (source_file == NULL) {
        printf("Unable to open the source file.\n");
        exit(EXIT_FAILURE);
    }

    // Open the destination file for writing
    dest_file = fopen(output_file, "w");
    if (dest_file == NULL) {
        fclose(source_file);
        printf("Unable to create the destination file.\n");
        exit(EXIT_FAILURE);
    }

    while (fgets(line, sizeof(line), source_file)) {
        // Check for single-line comments
        char *single_line_comment = strstr(line, "//");
        char *multi_line_comment_start = strstr(line, "/*");

        // Count single-line comments
        if (single_line_comment) {
            comment_count++;
            *single_line_comment = '\0'; // Eliminate single-line comment
        }

        // Handle multi-line comments
        char *multi_line_comment_end = strstr(line, "*/");
        if (multi_line_comment_start) {
            comment_count++;
            if (multi_line_comment_end) {
                *multi_line_comment_start = '\0'; // Eliminate start of multi-line comment
                multi_line_comment_end += 2; // Move past the end comment
                strcpy(line, multi_line_comment_end); // Copy the rest of the line
            } else {
                // If we found a start but no end, we need to ignore this line entirely
                continue;
            }
        }

        // Write the line without comments to the destination file
        fputs(line, dest_file);
    }

    // Closing files
    fclose(source_file);
    fclose(dest_file);

    // Print the number of comment lines found
    printf("Total comment lines found: %d\n", comment_count);
}

int main() {
    const char *input_file = "input.c";  // Specify your input C file
    const char *output_file = "output.c"; // Specify your output C file

    count_and_eliminate_comments(input_file, output_file);

    return 0;
}
