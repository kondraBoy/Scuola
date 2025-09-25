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
        if(nome.length < 2)
            document.getElementById(nomeError).innerHTML = "Deve avere minimo 2 caratteri";
        });

        document.getElementById("cognome").addEventListener("blur", () => {
        cognome[0] = cognome[0] - 32;
        if(cognome.length < 2)
            document.getElementById(cognomeError).innerHTML = "Deve avere minimo 2 caratteri";
        });

        document.getElementById("eta").addEventListener("blur", () => {
            const ogg=document.getElementById(etaError);
            if(controllaNum(eta) == false){
                ogg.innerHTML = "Non hai inserito un'età";
            }
            if(eta < 13)
                ogg.innerHTML = "Devi avere minimo 13 anni";
        });
    });

}

