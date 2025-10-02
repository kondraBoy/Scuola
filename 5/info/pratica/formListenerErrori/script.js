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

function minChar(text, numChar, id) {
    const obj = document.getElementById(id);
    if (text.length < numChar) {
        obj.innerHTML = `<p>Deve avere minimo ${numChar} caratteri\n</p>`;
    }
    else
        obj.innerHTML = "";
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
      obj.innerHTML = "<p>Non hai inserito un'età</p>";
    }
    if(eta < 13)
      obj.innerHTML = "<p>Devi avere almeno 13 anni</p>";
    else
      obj.innerHTML = "";
       
  });

    document.getElementById("pwd").addEventListener("blur", () => {
      const obj = document.getElementById("pwdError");
      let pwd = document.getElementById("pwd").value;
      let findCharSpec = false;
      let findUpper = false;
      let findLower = false;
      let findNumber = false;
      let caratteriSpeciali = "!£$%&/()=?^-_.;,@#+}§*{}[]";
      minChar(pwd,8,"pwd");
      for(let i=0;i<pwd.length;i++){
        if(caratteriSpeciali.includes(pwd[i]))
          findCharSpec = true;
        if(pwd[i] >= 'A' && pwd[i] <= 'Z')
          findUpper = true;
        if(pwd[i] >= 'a' && pwd[i] <= 'z')
          findLower = true;
        if(pwd[i] >= 48 && pwd[i] <= 57)
          findNumber = true;
      }
      if (findCharSpec && findUpper && findLower && findNumber){
          obj.innerHTML = "";  
      }
      if (!findCharSpec) {
          obj.innerHTML += "<p>Manca una carattere speciale tra i seguenti: !£$%&/()=?^-_.;,@#+}§*{}[];\n</p>"     
      }   
      if (!findNumber) {
          obj.innerHTML += "<p>Manca un numero\n</p>";
      }
      if (!findLower) {
          obj.innerHTML += "<p>Manca una minuscola\n</p>";
      }
      if (!findUpper) {
          obj.innerHTML += "<p>Manca una maiuscola\n</p>";        
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

