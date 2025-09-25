//Guarino Andrea 5BI script.js
function controllaNum(n){
	let check = true;
	if (isNaN(n) || n==null)
		check=false;
	return check;
} 

function controllaStr(str){
	let check = true;
	if(str == null || str == "")
		check=false;
	return check;
}

function leggiNum(vmin, vmax, msg){
	let num;
	do{
		num = prompt(msg,1);
		if(!controllaNum(num) || num < vmin || num > vmax)
			alert("Errore, inserisci un numero che sia maggiore di " + vmin + " e minore di " + vmax);
	}while(!controllaNum(num) || num < vmin || num > vmax);
	return num;
}

function minChar(text,numChar,id){
    const obj = document.getElementbyId(id);
    if(text.length < numChar)
        obj.innerHTML = "Deve avere minimo ${numChar} caratteri";
}

function convalida(form){
    let nome = form.nome.value;
    let cognome = form.cognome.value;
    let eta = form.eta.value;
    let sesso = form.sesso.value;
    let user = form.user.value;
    let pwd = form.pwd.value;

    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("nome").addEventListener("blur", () => {
        nome[0] = nome[0] - 32;
        minChar(nome,2,"nome");
        });

        document.getElementById("cognome").addEventListener("blur", () => {
        cognome[0] = cognome[0] - 32;
        minChar(cognome,2,"cognome");
        }); 

        document.getElementById("eta").addEventListener("blur", () => {
            const obj =document.getElementById(etaError);
            if(controllaNum(eta) == false){
                obj.innerHTML = "Non hai inserito un'età";
            }
            if(eta < 13)
                obj.innerHTML = "Devi avere minimo 13 anni";
        });

        document.getElementById("pwd").addEventListener("blur", () => {
            const obj = document.getElementById("pwd");
            let findCharSpec = false;
            let findUpper = false;
            let findLower = false;
            let caratteriSpeciali = "!£$%&/()=?^-_.;,@#+}§*{}[]";
            minChar(pwd,8,"pwd");
            for(let i=0;i<pwd.length;i++){
                if(caratteriSpeciali.includes().pwd[i]
                    findCharSpec = true;
                if(pwd[i] >= 'A' && pwd[i] <= 'Z')
                    findUpper = tru
                if(pwd[i] >= 'a' && pwd[i] <= 'z')
                    findLower = true
            }
            if(!findUpper)
                obj.innerHTML = "Manca una maiuscola";
            if(!findLower)
                obj.innerHTML = "Manca una minuscola";
            if(!findCharSpec)
                obj.innerHTML = "Manca una carattere speciale tra i seguenti:"!£$%&/()=?^-_.;,@#+}§*{}[];"
        });

        document.getElementById("sesso").addEventListener("blur", () => {
            const obj = document.getElementById("sesso");
            if(sesso === null)
                obj.innerHTML = "Non hai selezionato nulla"
        });
    });



}

