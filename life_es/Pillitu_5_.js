//Pillitu Luca - es.5.js - 13/11/2022
//js--> avanzamento delle generazioni delle caselle
const BIG = 32;
let mat = new Array(BIG);

//inizializzo valori
function initialize(){
    for(let j=0; j<BIG; j++){
        mat[j]=new Array();
        for(let i=0; i<BIG; i++){
            mat[j][i]=Math.floor(Math.random()*2);
        }
    }
    for (let i = 0; i < BIG; i++){
        mat[0][i] = 1;
        mat[i][0] = 1;
        mat[BIG - 1][i] = 1;
        mat[i][BIG - 1] = 1;
    }
    visualTable();
}

//stampa effettiva tabella
function visualTable(){
    html="";
    var colors=["yellow","purple"];//0 = yellow che vuol dire nato --> viota = morta o vuota
    for(let j=1; j<BIG-1; j++){
        for(let i=1; i<BIG-1; i++){
            if(mat[j][i] == 0){
                html+="<div class='glifo' id='g"+j+"x"+i+"' style='left:"+(((j)*1.6)+1.5)+"%; top:"+(((i)*3))+"%;background-color:"+colors[0]+"'></div>" 
            }else{
                html+="<div class='glifo' id='g"+j+"x"+i+"' style='left:"+(((j)*1.6)+1.5)+"%; top:"+(((i)*3))+"%;background-color:"+colors[1]+"'></div>" 
            }    
        }
    }
    document.getElementById("tab").innerHTML=html; 
}

//next --> se mat == 0 vive --> giallo le verdi sono "vuote"
function next(){
    newGeneration();
    convert();
    changeColor();
    
}

//setInterval(next,1000)
function newGeneration(){
    for(let j=1; j<BIG-1; j++){
        for(let i=1; i<BIG-1; i++){
            let cont = 0;
            if(mat[j][i]==1){
                cont = toWhoLive(i, j);
                if(cont==3)
                    mat[j][i]=2;//dovranno nascere
            }
            if(mat[j][i]==0){
                cont =  toWhoLive(i, j);
                    if(cont<2||cont>3)
                        mat[j][i]=3;
            }  
        }
    }
}

//convertirà il valore delle casse che devono nascere = 2 in 0 --> quelle che effettivamente nascono
function convert(){
    for(let j=0; j<BIG; j++){
        for(let i=0; i<BIG; i++){
                if(mat[j][i]==2)
                    mat[j][i]=0;
                if(mat[j][i]==3)
                    mat[j][i]=1;    
        }            
    }    
}

//funzione per inizializzare la matrice
function rand(){
    return  Math.trunc(Math.random()*2);
}

//funzione per il controllo se una cella dovrà vivere-rimanere-morire, rispetto alle celle attorno
function toWhoLive(x,y){
    let c = 0;
    for (let y1 = y - 1; y1 <= y + 1; y1++) {
        for (let x1 = x - 1; x1 <= x + 1; x1++) {
            if (mat[y1][x1] == 0 || mat[y1][x1] == 3) {
                c++;
            }
        }
    }
    if (mat[y][x] == 0){ c--; }

    return c;
}
    
//cambia il colore delle caselle senza ristampare l'intera tabella 
function changeColor(){
    var colors=["yellow","purple"];//0 = yellow che vuol dire nato --> viota = morta o vuota
    for(let j=1; j<BIG-1; j++){
        for(let i=1; i<BIG-1; i++){
            if(mat[j][i] == 0){
                document.getElementById("g"+j+"x"+i+"").style.backgroundColor = colors[0];
            }else{
                document.getElementById("g"+j+"x"+i+"").style.backgroundColor = colors[1];
            }    
        }
    }
}