#include <stdio.h>
#include <stdlib.h>

void stampa_divisori(int numero) {
    printf("Divisori di %d: ", numero);
    for (int i = 1; i <= numero; i++) {
        if (numero % i == 0) {
            printf("%d ", i);
        }
    }
    printf("\n");
}

void cubo(int numero) {
    printf("Il cubo di %d è: %d\n", numero, numero * numero * numero);
}

int main() {
    int numero;
    printf("Inserisci un numero intero: ");
    scanf("%d", &numero);
    pid_t pid = fork();
    if (pid < 0) {
        perror("Errore nella creazione del processo");
    } 
    else if (pid == 0) {
        cubo(numero);
    } 
    else {
        stampa_divisori(numero);
    }
    return 0;
}
