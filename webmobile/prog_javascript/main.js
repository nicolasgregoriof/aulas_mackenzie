const BASE_URL = "https://www.superheroapi.com/api.php";
const API_KEY = "6363218947044838";
var carta1,carta2,ponto1,ponto2,nome1,nome2;

function getRandom(){
    var cartas = [];
    
    for (var i = 0; i<2; i++){
        cartas[i] =  Math.floor(Math.random() * 731) + 1;
    }
    carta1 = cartas[0];
    carta2 = cartas[1];
}

window.onload = function() {
    this.getRandom();
    this.getAndShowHero1(carta1);
    this.getAndShowHero2(carta2);
}


function getAndShowHero1(c1){
    var url = BASE_URL + "/" + API_KEY + "/" + c1

    callAPI(url,function(status,data){
        let name = data.name
        let intelligence = data.powerstats.intelligence 
        let strength = data.powerstats.strength 
        let speed = data.powerstats.speed 
        let durability = data.powerstats.durability 
        let power = data.powerstats.power 
        let combat = data.powerstats.combat
        let image = data.image.url

        if (intelligence == 'null'){
            intelligence = '0'
        } else name = name;

        if (strength == 'null'){
            strength = '0'
        } else strength = strength;


        if (speed == 'null'){
            speed = '0'
        } else speed = speed;


        if (durability == 'null'){
            durability = '0'
        } else durability = durability;


        if (power == 'null'){
            power = '0'
        } else power = power;


        if (combat == 'null'){
            combat = '0'
        } else combat = combat;


        document.getElementById("content1").innerHTML += "<article> <div class='imagem'> <img src='" + image + "'/> </div>"+
        "<h1>" + name + "</h1>"+
        "<p>Intelligence: <span style='width:" + intelligence + "%; background-color: #F9B32F'></span></p>" + 
        "<p>Strength: <span style='width:" + strength + "%; background-color: #F9B32F'></span></p>" +
        "<p>Speed: <span style='width:" + speed + "%; background-color: #F9B32F'></span></p>" +
        "<p>Durability: <span style='width:" + durability + "%; background-color: #F9B32F'></span></p>" +
        "<p>Power: <span style='width:" + power +  "%; background-color: #F9B32F'></span></p>" +
        "<p>Combat: <span style='width:" + combat +  "%; background-color: #F9B32F'></span></p>" +
        "</article>";
        console.log(intelligence,strength,speed,durability,power,combat);
        ponto1 = parseFloat(intelligence) + parseFloat(strength) + parseFloat(speed) + parseFloat(durability) + parseFloat(power) + parseFloat(combat);
        nome1 = name;
    });
    
}

function getAndShowHero2(c2){
    var url = BASE_URL + "/" + API_KEY + "/" + c2

    callAPI(url,function(status,data){
        let name = data.name
        let intelligence = data.powerstats.intelligence
        let strength = data.powerstats.strength
        let speed = data.powerstats.speed
        let durability = data.powerstats.durability
        let power = data.powerstats.power
        let combat = data.powerstats.combat
        let image = data.image.url

        if (intelligence == 'null'){
            intelligence = '0'
        } else name = name;

        if (strength == 'null'){
            strength = '0'
        } else strength = strength;


        if (speed == 'null'){
            speed = '0'
        } else speed = speed;


        if (durability == 'null'){
            durability = '0'
        } else durability = durability;


        if (power == 'null'){
            power = '0'
        } else power = power;


        if (combat == 'null'){
            combat = '0'
        } else combat = combat;

        document.getElementById("content2").innerHTML += "<article>  <div class='imagem'> <img src='" + image + "'/> </div>"+
        "<h1>" + name + "</h1>"+
        "<p>Intelligence: <span style='width:" + intelligence + "%; background-color: #F9B32F'></span></p>" + 
        "<p>Strength: <span style='width:" + strength + "%; background-color: #F9B32F'></span></p>" +
        "<p>Speed: <span style='width:" + speed + "%; background-color: #F9B32F'></span></p>" +
        "<p>Durability: <span style='width:" + durability + "%; background-color: #F9B32F'></span></p>" +
        "<p>Power: <span style='width:" + power +  "%; background-color: #F9B32F'></span></p>" +
        "<p>Combat: <span style='width:" + combat +  "%; background-color: #F9B32F'></span></p>" +
        "</article>";

        ponto2 = parseFloat(intelligence) + parseFloat(strength) + parseFloat(speed) + parseFloat(durability) + parseFloat(power) + parseFloat(combat);
        nome2 = name;

    });
}

function getGanhador(j1,j2){
        /*document.getElementById("ganhador").innerHTML += "<h2>"+j1+j2+" </h2>";*/
        if(j1>j2){
            document.getElementById("ganhador").innerHTML += "<h2>Vencedor(a)  é "+nome1+"!<br>"+nome1+" fez "+j1+" pontos e "+nome2+" fez "+j2+" pontos</h2>";
        } else if(j1<j2){
            document.getElementById("ganhador").innerHTML += "<h2>Vencedor(a)  é "+nome2+"!<br>"+nome1+" fez "+j1+" pontos e "+nome2+" fez "+j2+" pontos</h2>";
        } else{
            document.getElementById("ganhador").innerHTML += "<h2>Ops... Deu empate, os heróis possuem a mesma pontuação!<br>"+nome1+" fez "+j1+" pontos e "+nome2+" fez "+j2+" pontos</h2>";
        }
}


setTimeout(function(){
    getGanhador(ponto1,ponto2);
},2000);

function callAPI(url,callback){
    var xhr = new XMLHttpRequest();
    xhr.open('GET',url,true);
    xhr.responseType = 'json';
    xhr.onload = function(){
        var status = xhr.status;
        if (status === 200){
            callback(status,xhr.response);
        } else {
            alert("Problemas ao conectar o servidor")
        }
    }
    xhr.send();
}