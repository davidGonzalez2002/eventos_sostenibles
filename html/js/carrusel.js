const contenedor = document.querySelector('.carrusel .contenedor');
const controles = document.querySelectorAll('.carrusel .controles li');


var actual = 0; //Elemento actual del carrusel, empieza siendo 0

function rotarCarrusel(control,i){
    let tranformacion = i*-(100/contenedor.childElementCount); //Calculo el moviemiento en el eje x en funcion del numero de elementos

    contenedor.style.transform = 'translateX('+tranformacion+'%)'; //Aplico el movimiento

    controles.forEach((control)=>control.classList.remove('actual')); //Quito la clase activo de todos
    control.classList.add('actual'); //Se la pongo al actual
}

//ponemos el carrusel en la posicion inicial
rotarCarrusel(controles[0],0);

controles.forEach((control,i)=>{
    control.addEventListener('click',()=>{
        rotarCarrusel(control,i)
        actual=i; //Marcamos este como el elemento actual para que se sigua moviendo automaticamente desde aqui
    });
});

setInterval(()=>{
    rotarCarrusel(controles[actual],actual);
    actual>=contenedor.childElementCount-1?actual=0:actual++; //Incrementar al actual si no pasa del numero maximo de elementos del carrusel-1
},3000);

