//Guarino Andrea 4BI funzioniControllo.js
function controllaNum(n){
	let check = true;
	if (isNaN(n) || n==null)
		check=false;
	return check;
} 
        
function controllaStr(str){
	let check = true;
	if(nome!=null || nome!=""){
		check=false;
	}
	return check;
}

function leggiNum(vmin, vmax, msg){
	let num;
	do{
		num = prompt(msg,1);
		if(!controllaNum(num) && (num < vmin || num > vmax))
			alert("Errore, inserisci un numero che sia maggiore di " + min + " e minore di " + max);
	}while(!controllaNum(num) && (num < vmin || num > vmax));
	return num;
}