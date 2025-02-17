function validateForm(event) {
            let errors = [];
            let nome = document.getElementById('nome').value;
            let cognome = document.getElementById('cognome').value;
            let eta = document.getElementById('eta').value;
            let genereMaschio = document.getElementById('maschio').checked;
            let genereFemmina = document.getElementById('femmina').checked;
            let colore = document.getElementById('colore').value;
            let consenso = document.getElementById('consenso').checked;

            
            if (nome === '') {
                errors.push("Il nome è obbligatorio.");
            }

            
            if (cognome === '') {
                errors.push("Il cognome è obbligatorio.");
            }

            
            if (eta === '') {
                errors.push("L'età è obbligatoria.");
            }

            
            if (!genereMaschio && !genereFemmina) {
                errors.push("Seleziona un genere.");
            }

            
            if (colore === '') {
                errors.push("Seleziona un colore preferito.");
            }

            
            if (!consenso) {
                errors.push("Devi dare il tuo consenso.");
            }

            
            if (errors.length > 0) {
                alert("Errore: " + errors.join(", "));
                event.preventDefault();  
            } else {
                alert("Tutto ok! Il form è stato inviato.");
            }
        }

        
        let form = document.getElementById('form');
        form.addEventListener('submit', validateForm);