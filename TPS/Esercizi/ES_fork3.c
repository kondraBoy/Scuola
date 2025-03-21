#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    int num1, num2, num3, num4;
    pid_t pid;

    // Chiedi i 4 numeri in input
    printf("Inserisci il primo numero: ");
    scanf("%d", &num1);
    printf("Inserisci il secondo numero: ");
    scanf("%d", &num2);
    printf("Inserisci il terzo numero: ");
    scanf("%d", &num3);
    printf("Inserisci il quarto numero: ");
    scanf("%d", &num4);

    // Creazione del processo figlio
    pid = fork();

    if (pid < 0) {
        // Se fork fallisce
        printf("Errore nella creazione del processo figlio.\n");
        exit(1);
    } else if (pid == 0) {
        // Processo figlio: calcola e stampa la media
        float media = (num1 + num2 + num3 + num4) / 4.0;
        printf("Processo figlio: La media dei numeri è %.2f.\n", media);
    } else {
        // Processo padre: trova e stampa il massimo
        int massimo = num1;

        if (num2 > massimo) massimo = num2;
        if (num3 > massimo) massimo = num3;
        if (num4 > massimo) massimo = num4;

        printf("Processo padre: Il numero maggiore è %d.\n", massimo);
    }

    return 0;
}
