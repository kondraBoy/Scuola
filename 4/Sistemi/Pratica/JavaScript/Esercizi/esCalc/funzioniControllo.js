//Guarino Andrea 4BI funzioniControllo.js
function ctrlNum(n){
	let check = true;
	if (isNaN(n) || n==null)
		check=false;
	return check;
} 
        
function ctrlStr(str){
	let check = true;
	if(str!=null || str!=""){
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