#include <stdio.h>




int main(void)
{
    while (1)
    {
        for (int i = 0; i < 10000000; i++) {}
        printf("Hello World\n\r");
    }

    return 0;
}
