#include <stdio.h>
#include <stdlib.h>

int main() {
    int num1, num2;
    printf("Inserisci il primo numero: ");
    scanf("%d", &num1);
    printf("Inserisci il secondo numero: ");
    scanf("%d", &num2);
    pid_t pid = fork();
    if (pid < 0) {
        printf("Errore nella creazione del processo");
        
    }
    if (pid == 0) {
        int prodotto = num1 * num2;
        printf("Processo figlio: Il prodotto di %d e %d è %d\n", num1, num2, prodotto);
    } else {
        int somma = num1 + num2;
        printf("Processo padre: La somma di %d e %d è %d\n", num1, num2, somma);
    }
    return 0;
}
