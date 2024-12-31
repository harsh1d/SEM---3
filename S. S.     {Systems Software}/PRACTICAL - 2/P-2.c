// Write a C program to test whether a given identifier is valid or not.
#include <stdio.h>

int main()
{
    char ch;
    int flag = 0;
    printf("Enter a character: ");
    scanf("%c", &ch);
    if (ch >= 'a' && ch <= 'z')
    {
        flag = 1;
    }
    else
    {
        if (ch >= 'A' && ch <= 'Z')
        {
            flag = 1;
        }
        else
        {
            if (ch >= '0' && ch <= '9')
            {
                flag = 1;
            }
            else
            {
                if (ch == '_')
                {
                    flag = 1;
                }
                else
                {
                    flag = 0;
                }
            }
        }
    }
    if (flag == 1)
    {
        printf("The given character is a valid identifier");
    }
    else
    {
        printf("The given character is not a valid identifier");
    }
    return 0;
}

