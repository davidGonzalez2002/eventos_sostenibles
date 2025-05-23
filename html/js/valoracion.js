const estrellas = document.querySelectorAll('.estrella');

var puntuacionActual=3;

function darPuntos(puntos){
    for(let i=0;i<estrellas.length;i++){
        estrellas[i].src="./images/estrella_gris.png";
    }
    for(let i=0;i<puntos;i++){
        estrellas[i].src="./images/estrella.png";
    }
}

darPuntos(puntuacionActual);

estrellas.forEach((estrella)=>{
    estrella.addEventListener('click',()=>{
        darPuntos(estrella.getAttribute('valor'));
    })
})