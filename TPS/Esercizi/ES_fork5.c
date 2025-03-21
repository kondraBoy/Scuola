#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    int N, i, num, somma = 0;
    pid_t pid;
    FILE *file;

    // Chiedi il numero N di numeri da inserire
    printf("Inserisci il numero di numeri da scrivere nel file: ");
    scanf("%d", &N);

    // Creazione del processo figlio
    pid = fork();

    if (pid < 0) {
        // Errore nella creazione del processo figlio
        printf("Errore nella creazione del processo figlio.\n");
        exit(1);
    } else if (pid == 0) {
        // Processo figlio: scrivere i numeri nel file
        file = fopen("numeri.txt", "w");
        if (file == NULL) {
            printf("Errore nell'aprire il file per la scrittura.\n");
            exit(1);
        }

        printf("Processo figlio: Inserisci %d numeri:\n", N);
        for (i = 0; i < N; i++) {
            printf("Numero %d: ", i + 1);
            scanf("%d", &num);
            fprintf(file, "%d\n", num);  // Scrivere il numero nel file
        }

        fclose(file);
        printf("Processo figlio: Scrittura completata nel file 'numeri.txt'.\n");

        exit(0);
    } else {
        // Processo padre: attende che il figlio termini
        wait(NULL);

        // Il processo padre legge i numeri dal file e calcola la somma
        file = fopen("numeri.txt", "r");
        if (file == NULL) {
            printf("Errore nell'aprire il file per la lettura.\n");
            exit(1);
        }

        printf("Processo padre: Lettura dei numeri dal file...\n");
        for (i = 0; i < N; i++) {
            fscanf(file, "%d", &num);  // Leggere il numero dal file
            somma += num;               // Calcolare la somma
        }

        fclose(file);

        // Scrivere la somma e il messaggio nel file
        file = fopen("numeri.txt", "a");
        if (file == NULL) {
            printf("Errore nell'aprire il file per l'append.\n");
            exit(1);
        }

        fprintf(file, "Somma: %d\n", somma);
        fprintf(file, "Mio figlio (PID %d) è terminato con stato: ", pid);
        fprintf(file, "OK\n");

        fclose(file);

        printf("Processo padre: La somma dei numeri è %d.\n", somma);
        printf("Processo padre: Messaggio scritto nel file.\n");
    }

    return 0;
}
