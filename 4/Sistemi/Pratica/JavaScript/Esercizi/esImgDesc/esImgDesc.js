/*Andrea Guarino 4BI esImgDesc.js
Gestisco la struttura dati attraverso l'utilizzo di un array di oggetti e gestisco le funzioni dei click facendomi passare 
come parametro la posizione che le immagini hanno all'interno dell'array. 
Quindi la prima immagine (indice 0) trasmette la sua posizione nell'array per localizzare le informazioni da trasmettere */

const quadri=[
	{nome:"Gioconda" , desc:"La Gioconda, anche conosciuta come Monna Lisa, è probabilmente il dipinto più famoso al mondo. Rappresenta una donna dall'espressione enigmatica, seduta di fronte a uno sfondo di paesaggio lontano. Il volto di Mona Lisa è caratterizzato da un sorriso misterioso che sembra cambiare a seconda della prospettiva di chi osserva il quadro. La sua tecnica sfumata, nota come sfumato, crea un effetto di morbidezza e realismo, mentre il contrasto tra il volto e il paesaggio sottolinea l'intensità psicologica del dipinto." , carat:"topolino"},
	{nome:"Bacio di Klimt" , desc:"Quest'opera è una delle più celebri del pittore austriaco Gustav Klimt. Realizzata tra il 1907 e il 1908, Il Bacio rappresenta una coppia che si abbraccia e si bacia, avvolta da un ricco manto dorato. Il quadro è simbolo di amore, intimità e passione, ed è famoso per la sua ornamentazione ricca di motivi dorati, che conferiscono una qualità quasi eterea alla scena. La fusione tra la figura umana e i dettagli decorativi è tipica dello stile di Klimt, che unisce simbolismo e modernismo con un tocco sensuale e raffinato." , carat:"minnie"},
	{nome:"Notte stellata di Van Gogh" , desc:"Questo celebre dipinto è stato realizzato nel 1889 e ritrae un paesaggio notturno visto dalla finestra della stanza dell'artista, con un cielo turbinante e stelle che sembrano brillare intensamente. Il cielo è caratterizzato da spirali di colore blu, giallo e bianco, creando un effetto dinamico e quasi psichedelico. In basso, un paesaggio tranquillo e una piccola chiesa si trovano sotto il cielo vibrante. La tecnica del pennello di Van Gogh, visibile in ogni tratto, e l'uso emozionale del colore sono centrali in questo dipinto, che esprime sia un senso di solitudine che una bellezza straordinaria." , carat:"aristogatti"}
]

function showDesc(pos){
	document.getElementById("output").innerHTML = quadri[pos].desc;
}

function showCarat(pos){
	document.getElementById("output").innerHTML = quadri[pos].carat;
}