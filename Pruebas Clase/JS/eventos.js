const cMS = "WordPress";
const temperatura = "Frio";
var x = 2;
var y = 3;
var z = x + y;
var nombre = " Cristina";
apellido = " García";
edad = 39;

function funcionEjer1() {
  document.getElementById("ejer1").innerHTML = "50";
}

function funcionEjer2() {
  document.getElementById("cms1").innerHTML = cMS;
}

function funcionEjer3() {
  document.getElementById("temp").innerHTML = temperatura;
}

function funcionEjer4() {
  document.getElementById("sum").innerHTML = x + y;
}

function funcionEjer5() {
  x = 5;
  y = 10;
  z = x + y;
  document.getElementById("sum").innerHTML = z;
}

function funcionEjer6() {
  document.getElementById("persona").innerHTML =
    nombre + " " + apellido + " tiene " + edad + " años";
}

function funcionEjer7() {
  x = 1;
  y = 6;
  z = x + y;
  document.getElementById("donde").innerHTML = z;
}

function funcionEjer8() {
  x = 60;
  document.getElementById("division").innerHTML = x / 3;
}

function funcionEjer9() {
  x = "6";
  y = "9";
  z = x * y;
  document.getElementById("mult").innerHTML = z;
}

function funcionEjer10() {
  document.getElementById("clickEj10").innerHTML = "¡BUEN TRABAJO!";
}

function funcionEjer11() {
  document.getElementById("clickEj11").innerHTML = "Hola Mundo";
}

function funcionEjer12() {
  document.getElementById("encimaEjer12").style.color = "red";
}
