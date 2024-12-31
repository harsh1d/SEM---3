#include <stdio.h>

// Define a macro for the value of PI
#define PI 3.1415

// Define a macro for calculating the area of a circle
#define CIRCLE_AREA(r) (PI * (r) * (r))

// Define a macro for the maximum of two numbers
#define MAX(a, b) ((a) > (b) ? (a) : (b))

// Define a macro for printing a message
#define PRINT_MSG(msg) printf("%s\n", msg)

int main() {
    float radius, area;
    int num1, num2, max;

    // Using the CIRCLE_AREA macro
    printf("Enter the radius of the circle: ");
    scanf("%f", &radius);
    area = CIRCLE_AREA(radius);
    printf("Area of the circle: %.2f\n", area);

    // Using the MAX macro
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    max = MAX(num1, num2);
    printf("The maximum of %d and %d is %d\n", num1, num2, max);

    // Using the PRINT_MSG macro
    PRINT_MSG("This is a message printed using a macro!");

    return 0;
}

