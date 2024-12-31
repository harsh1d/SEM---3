// Write a Program for first pass and second pass Assembler.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LABEL_LEN 20
#define MAX_OPCODE_LEN 10
#define MAX_OPERAND_LEN 20
#define MAX_LINE_LEN 100
#define MAX_SYMBOLS 100

typedef struct {
    char label[MAX_LABEL_LEN];
    int address;
} Symbol;

Symbol symbolTable[MAX_SYMBOLS];
int symbolCount = 0;

int searchSymbol(char *label) {
    for (int i = 0; i < symbolCount; i++) {
        if (strcmp(symbolTable[i].label, label) == 0) {
            return symbolTable[i].address;
        }
    }
    return -1;
}

void addSymbol(char *label, int address) {
    strcpy(symbolTable[symbolCount].label, label);
    symbolTable[symbolCount].address = address;
    symbolCount++;
}

void firstPass(FILE *input) {
    char line[MAX_LINE_LEN];
    int address = 0;

    while (fgets(line, sizeof(line), input)) {
        char label[MAX_LABEL_LEN], opcode[MAX_OPCODE_LEN], operand[MAX_OPERAND_LEN];
        int numFields = sscanf(line, "%s %s %s", label, opcode, operand);

        if (numFields == 3) {
            if (searchSymbol(label) == -1) {
                addSymbol(label, address);
            }
        }

        address += 4; // Assuming each instruction is 4 bytes
    }
}

void secondPass(FILE *input, FILE *output) {
    char line[MAX_LINE_LEN];
    int address = 0;

    rewind(input);

    while (fgets(line, sizeof(line), input)) {
        char label[MAX_LABEL_LEN], opcode[MAX_OPCODE_LEN], operand[MAX_OPERAND_LEN];
        int numFields = sscanf(line, "%s %s %s", label, opcode, operand);

        if (numFields == 3) {
            fprintf(output, "%04X %s %s %s\n", address, label, opcode, operand);
        } else if (numFields == 2) {
            fprintf(output, "%04X %s %s\n", address, label, opcode);
        } else if (numFields == 1) {
            fprintf(output, "%04X %s\n", address, label);
        }

        address += 4; // Assuming each instruction is 4 bytes
    }
}

int main() {
    FILE *input = fopen("input.asm", "r");
    FILE *output = fopen("output.obj", "w");

    if (!input || !output) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    firstPass(input);
    secondPass(input, output);

    fclose(input);
    fclose(output);

    return EXIT_SUCCESS;
}