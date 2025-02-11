// Funzione di validazione per il form
function validateForm(event) {
    // Prevenire l'invio del modulo
    event.preventDefault();

    // Resettare gli errori
    let errors = false;
    document.querySelectorAll('.error').forEach(error => error.textContent = '');

    // Recuperare i valori dei campi
    const nome = document.getElementById('nome').value;
    const cognome = document.getElementById('cognome').value;
    const eta = document.getElementById('eta').value;
    const genereM = document.getElementById('genereM').checked;
    const genereF = document.getElementById('genereF').checked;
    const colore = document.getElementById('colore').value;
    const consenso = document.getElementById('consenso').checked;

    // Validare il nome
    if (nome.trim() === '') {
        document.getElementById('nomeError').textContent = 'Il nome è obbligatorio.';
        errors = true;
    }

    // Validare il cognome
    if (cognome.trim() === '') {
        document.getElementById('cognomeError').textContent = 'Il cognome è obbligatorio.';
        errors = true;
    }

    // Validare l'età
    if (eta === '') {
        document.getElementById('etaError').textContent = 'L\'età è obbligatoria.';
        errors = true;
    }

    // Validare il genere
    if (!genereM && !genereF) {
        document.getElementById('genereError').textContent = 'Seleziona un genere.';
        errors = true;
    }

    // Validare il colore preferito
    if (colore === '') {
        document.getElementById('coloreError').textContent = 'Seleziona un colore preferito.';
        errors = true;
    }

    // Validare il consenso
    if (!consenso) {
        document.getElementById('consensoError').textContent = 'Devi acconsentire al trattamento dei dati.';
        errors = true;
    }

    // Mostrare l'alert finale
    if (errors) {
        alert('Manca qualcosa, per favore completa tutti i campi.');
    } else {
        alert('Tutto apposto! Il modulo è stato inviato correttamente.');
        // Inviare il modulo (puoi anche scommentare la linea seguente se vuoi inviarlo realmente)
        // event.target.submit();
    }
}
