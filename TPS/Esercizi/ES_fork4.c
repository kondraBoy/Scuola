#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

void sostituisci_vocali(char *str) {
    // Sostituire le vocali con '*'
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' ||
            str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U') {
            str[i] = '*';
        }
    }
}

int main() {
    char parola[100];
    pid_t pid1, pid2;

    // Chiedere la parola in input
    printf("Inserisci una parola: ");
    scanf("%s", parola);

    // Creazione del primo processo figlio (per sostituire le vocali con '*')
    pid1 = fork();

    if (pid1 < 0) {
        // Errore nella creazione del processo figlio
        printf("Errore nella creazione del primo processo figlio.\n");
        exit(1);
    } else if (pid1 == 0) {
        // Primo processo figlio: sostituire le vocali con '*'
        sostituisci_vocali(parola);
        printf("Primo processo figlio: Parola con vocali sostituite: %s\n", parola);
        exit(0);
    } else {
        // Creazione del secondo processo figlio (per stampare la lunghezza della parola)
        pid2 = fork();

        if (pid2 < 0) {
            // Errore nella creazione del secondo processo figlio
            printf("Errore nella creazione del secondo processo figlio.\n");
            exit(1);
        } else if (pid2 == 0) {
            // Secondo processo figlio: stampare la lunghezza della parola
            int lunghezza = strlen(parola);
            printf("Secondo processo figlio: La lunghezza della parola è %d.\n", lunghezza);
            exit(0);
        } else {
            // Processo padre: scrivere la parola in un file di testo
            FILE *file = fopen("parola.txt", "w");
            if (file == NULL) {
                printf("Errore nell'aprire il file.\n");
                exit(1);
            }
            fprintf(file, "%s\n", parola);
            fclose(file);
            printf("Processo padre: La parola è stata scritta nel file 'parola.txt'.\n");

            // Aspetta che i figli terminino
            wait(NULL);
            wait(NULL);
        }
    }

    return 0;
}
