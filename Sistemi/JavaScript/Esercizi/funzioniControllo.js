function controllaNum(n){
	let check = true;
	if (isNaN(n) || n < 0)
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

function leggiNum(msg){
	let num;
	do{
		num=prompt(msg,1);
		if(!controllaNum(num)){
			alert("Il numero è minore di 0 oppure non è stato inserito un numero");
		}
	}while(!controllaNum(num));
	return num;
}