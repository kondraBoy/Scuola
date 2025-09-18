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
    let colore = form.colore.value;
    let sesso = form.sesso.value;
    let strErr = "";
    let esito = true;

    if(controllaStr(nome) === false){
        strErr += "Il nome non va bene\n";
    }
    if(controllaStr(cognome) === false){
        strErr += "Il cognome non va bene\n";
    }

    if(controllaStr(colore) === false){
        strErr += "Il colore non è stato scelto\n";
    }

    if(controllaStr(sesso) === false){
        strErr += "Il sesso non è stato scelto\n";
    }

    if(controllaStr(strErr) === true){
        alert(strErr);
        esito = false;
    }

    return esito;
}
