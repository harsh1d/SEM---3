// Write A program to show linker.

// functions.h
#ifndef FUNCTIONS_H
#define FUNCTIONS_H

    void
    printMessage();

#endif
// functions.c
#include <stdio.h>
#include "functions.h"

void printMessage() {
    printf("Hello from the linked function!\n");
}

// main.c
#include "functions.h"

int main() {
    printMessage();
    return 0;
}