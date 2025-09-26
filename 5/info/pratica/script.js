//Guarino Andrea 5AI script.js
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
    const obj = document.getElementById(id);
    if(text.length < numChar)
        obj.innerHTML = 'Deve avere minimo " + numChar +" caratteri';
}
document.addEventListener("DOMContentLoaded", function() {

  document.getElementById("nome").addEventListener("blur", () => {
     let nome = document.getElementById("nome").value;
     nome[0] = nome[0] - 32;
     minChar(nome,2,"nomeError");
  });

  document.getElementById("cognome").addEventListener("blur", () => {
     let cognome = document.getElementById("cognome").value;
     cognome[0] = cognome[0] - 32;
     minChar(cognome,2,"cognomeError");
  });

  document.getElementById("eta").addEventListener("blur", () => {
     const obj = document.getElementById("etaError");
     let eta = document.getElementById("eta").value;
     if(controllaNum(eta) == false){
       obj.innerHTML = "Non hai inserito un'età";
     }
     if(eta < 13)
       obj.innerHTML = "Devi avere minimo 13 anni";
  });

    document.getElementById("pwd").addEventListener("blur", () => {
      const obj = document.getElementById("pwdError");
      let pwd = document.getElementById("pwd").value;
      let findCharSpec = false;
      let findUpper = false;
      let findLower = false;
      let caratteriSpeciali = "!£$%&/()=?^-_.;,@#+}§*{}[]";
      minChar(pwd,8,"pwd");
      for(let i=0;i<pwd.length;i++){
        if(caratteriSpeciali.includes(pwd[i]))
          findCharSpec = true;
        if(pwd[i] >= 'A' && pwd[i] <= 'Z')
          findUpper = true;
        if(pwd[i] >= 'a' && pwd[i] <= 'z')
          findLower = true;
      }
        if(!findUpper)
          obj.innerHTML = "Manca una maiuscola";
        if(!findLower)
          obj.innerHTML = "Manca una minuscola";
        if(!findCharSpec)
          obj.innerHTML = "Manca una carattere speciale tra i seguenti: !£$%&/()=?^-_.;,@#+}§*{}[];"
    });

    document.getElementById("sesso").addEventListener("blur", () => {
      const radios = document.getElementsByName("sesso");
      let selezionato = false;
      for (let i = 0; i < radios.length && selezionato = false; i++) {
        if (radios[i].checked) {
          selezionato = true;
        }
      }
      if (!selezionato) {
        document.getElementById("sessoError").innerText = "Seleziona un'opzione";
      }
            
    });
});


function convalida(form){
  let valid = true;
  const errorIds = ["nomeError", "cognomeError", "userError", "pwdError", "etaError", "sessoError"];
  errorIds.forEach(id => {
  const err = document.getElementById(id);
  if (err && err.innerHTML.trim() !== "") {
      valid = false;
    }
  });
  return valid;
}

