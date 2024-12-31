#include <stdio.h>
#include <string.h>

typedef struct {
    char op[10];
    char arg1[10];
    char arg2[10];
    char result[10];
} Triple;

void generateTriple(char *statement, Triple *triples, int *count) {
    char lhs[10], rhs[10];
    sscanf(statement, "%s = %s", lhs, rhs);

    strcpy(triples[*count].op, "=");
    strcpy(triples[*count].arg1, rhs);
    strcpy(triples[*count].arg2, "");
    strcpy(triples[*count].result, lhs);
    (*count)++;
}

void printTriples(Triple *triples, int count) {
    for (int i = 0; i < count; i++) {
        printf("(%d) (%s, %s, %s, %s)\n", i, triples[i].op, triples[i].arg1, triples[i].arg2, triples[i].result);
    }
}

int main() {
    char statement[50];
    Triple triples[10];
    int count = 0;

    printf("Enter an assignment statement: ");
    gets(statement);

    generateTriple(statement, triples, &count);
    printTriples(triples, count);

    return 0;
}