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