#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid[4]; // Array per memorizzare gli ID dei processi figli
    int tempi[4]; // Array per memorizzare i tempi di attesa dei figli
    int max_time = 0, max_index = -1;

    // Creazione dei 4 processi figli
    for (int i = 0; i < 4; i++) {
        pid[i] = fork(); // Crea un processo figlio

        if (pid[i] < 0) {
            // Gestione errore nel caso fork fallisca
            printf("Errore nella creazione del processo figlio %d.\n", i + 1);
            exit(1);
        } else if (pid[i] == 0) {
            // Codice del processo figlio
            printf("Processo figlio %d: Inserisci il tempo di attesa in secondi: ", i + 1);
            scanf("%d", &tempi[i]);

            // Il processo figlio dorme per il tempo di attesa specificato
            sleep(tempi[i]);
            printf("Processo figlio %d: Sono terminato dopo %d secondi di attesa.\n", i + 1, tempi[i]);
            exit(0); // Il processo figlio termina
        }
    }

    // Il processo padre attende il processo figlio con il tempo di attesa maggiore
    for (int i = 0; i < 4; i++) {
        if (pid[i] > 0) {
            // Chiediamo al padre di ottenere il massimo tempo di attesa tra i figli
            printf("Attendo che il figlio %d finisca...\n", i + 1);

            if (tempi[i] > max_time) {
                max_time = tempi[i];
                max_index = i;
            }
        }
    }

    // Il processo padre aspetta il figlio con il massimo tempo di attesa
    if (max_index >= 0) {
        waitpid(pid[max_index], NULL, 0); // Attendere il processo figlio con attesa maggiore
        printf("Processo padre: Il figlio %d (PID %d) è terminato con il massimo tempo di attesa di %d secondi.\n", max_index + 1, pid[max_index], max_time);
    }

    return 0;
}
