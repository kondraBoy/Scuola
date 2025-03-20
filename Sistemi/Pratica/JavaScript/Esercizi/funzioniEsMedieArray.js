	function inserisci() {
		const voto = document.getElementById("votoInput");
		if(controllaNum(voto.value)){
			if (voto.value >= 1 && voto.value <= 10) {
				voti.push(voto.value);
				document.getElementById("output").textContent = "Voti inseriti: " + voti.join(", ");
			} else {
				alert("Inserisci un voto valido (1-10).");
			}
		}else
			alert("Ciò che è stato inserito non è un numero");
		voto.value ="";
		document.getElementById("visi").style.visibility = "visible";
	}

        
	function resetArray() {
		for(let i=voti.length;i>=0;i--){
			voti.pop();
		}
		document.getElementById("output").textContent = "Voti resettati." + voti.toString();
	}

  
	function calcolaAritmetica() {
		if (voti.length === 0) {
			alert("Inserisci almeno un voto!");
		}else{
			let somma = 0;
			for(let i=0;i<voti.length;i++){
				somma += voti[i];
			}
			let media = somma / voti.length;
			document.getElementById("output").textContent = "Media aritmetica: " + media.toFixed(2);
		}
	}

	function calcolaGeometrica() {
		if (voti.length === 0) {
			alert("Inserisci almeno un voto!");
		}else{
			const prodotto = voti.reduce((acc, val) => acc * val, 1);
			const mediaGeometrica = Math.pow(prodotto, 1 / voti.length);
			document.getElementById("output").textContent = "Media geometrica: " + mediaGeometrica.toFixed(2);
		}
	}
