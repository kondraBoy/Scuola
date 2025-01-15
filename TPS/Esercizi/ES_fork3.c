/*Crea una procedura che crea un figlio, facendo terminare prima il figlio poi il padre, nel main si chiede quanti figli creare e si cicla la funzione n volte*/

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>  

int main(){
    int n;
	printf("Quanti thread vuoi generare ? \n");
	scanf("%i",&n);
	for(int i=0;i<n;i++){
		genThread();
	}
    return 0;
}

void genThread(){
	pid_t pid = fork();
	if(pid == 0){
		//figlio
		printf("Ciao sono il processo figlio: PF: %d PP: %d",getpid(),getppid());
		exit(1);
	}else{
		//padre
		printf("Ciao sono il processo padre: PF: %d PP: %d",getpid(),getppid());
	}
}