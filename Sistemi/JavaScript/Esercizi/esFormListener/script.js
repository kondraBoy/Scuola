function validateForm(frm) {
    const frmValid = false; 
    const errors = [];
    const nome = frm.nome;
    const cognome = frm.cognome;
    const eta = frm.eta;
    const genere = frm.genere;
    const colore = frm.colore;
    const consenso = frm.consenso;
	
    if (nome.value === '') {
        alert("Il nome è obbligatorio.");
        nome.focus();
    }
	else if (cognome.value === '') {
        alert("Il cognome è obbligatorio.");
        frm.cognome.focus();
    }else if (eta.value === '' || eta < 0 || isNan(eta.value)) {
        alert("L'età è obbligatoria e deve essere un numero valido.");
        frm.eta.focus();
    }else if (!genere) {
        alert("Seleziona un genere.");
        frm.maschio.focus(); 
    }else if (colore.value === '') {
        alert("Seleziona un colore preferito.");
        frm.colore.focus();
    }else if (!consenso) {
        alert("Devi dare il tuo consenso.");
        frm.consenso.focus();
    }
	else
	{
		frmValid=true;
        alert("Tutto ok! Il frm è stato inviato.");
    }
	return frmValid;
}

