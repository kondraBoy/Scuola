
function Calcolav1(){
	let n1=document.getElementById("n1");
	let op=document.getElementById("op");
	let n2=document.getElementById("n2");
	let ris;
	if(checkExp(n1,op,n2)){
		ris = calcola(parseFloat(n1),op,parseFloat(n2));
	}
		
}

function checkExp(n1,op,n2){
	check = true;
	if(!ctrlNum(n1)){
		alert("Il primo valore inserito non è un numero");
		check = false;
	}
	if(!ctrlNum(n2)){
		alert("Il secondo valore inserito non è un numero");
		check = false;
	}
	if(!ctrlStr(op)){
		alert("L'operatore inserito non è valido o non inserito");
		check = false;
	}	
	return check;
}

function calcola(n1,op,n2){
	let ris;
	switch(op){
		case '+':{
			
			break;
		}
	}
}