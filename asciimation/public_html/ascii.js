/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

var vdelay=250;
var timer = null;
var Tanimation="";
var Tfotograma="";
var TindexFotograma=0;
var TmaxFotograma=0;
var TanimExec=false;
var TarregloDeSubCadenas=null;
var separador = "=====\n";


function ChangeSize() {
    var aa = document.getElementById("animationarea");
    var newsize = document.getElementById("selsize").value;
    aa.style.fontSize = newsize;
}

function ChangeAnimation(){
    var newanimation = document.getElementById("selanimation").value;
    var aa = document.getElementById("animationarea");
    if(newanimation === "Exercise"){
        aa.value = EXERCISE;            
    }else if(newanimation === "Juggler"){
        aa.value = JUGGLER;            
    }else if(newanimation === "Bike"){
        aa.value = BIKE;            
    }else if(newanimation === "Dive"){
        aa.value = DIVE;            
    }else if(newanimation === "Custom"){
        aa.value = CUSTOM;
    }else{
        aa.value = BLANK;        
    }
}

function Speed(){
    var ct = document.getElementById("cturbo");
    if (ct.checked===true){
        vdelay=50;
    }else{
        vdelay=250;
    }
    if(TanimExec===true){
        clearInterval(timer);
        timer = setInterval(fun1, vdelay);
    }
}

function StartAnimation(){
    var aa = document.getElementById("animationarea");
    var bstartx = document.getElementById("bstart");
    var bstopx = document.getElementById("bstop");
    var newanimation = document.getElementById("selanimation");
    bstartx.disabled=true;
    bstopx.disabled=false;
    newanimation.disabled=true;
    Tanimation=aa.value;
    TanimExec=true;
    TarregloDeSubCadenas = Tanimation.split(separador);
    TmaxFotograma=TarregloDeSubCadenas.length;
    timer = setInterval(fun1, vdelay);
}

function fun1(){
    var aa = document.getElementById("animationarea");
    aa.value=TarregloDeSubCadenas[TindexFotograma];
    TindexFotograma=TindexFotograma+1;
    if(TindexFotograma>=TmaxFotograma){
        TindexFotograma=0;
    }
}

function StopAnimation(){
    var bstartx = document.getElementById("bstart");
    var bstopx = document.getElementById("bstop");
    bstartx.disabled=false;
    bstopx.disabled=true;    
    clearInterval(timer);
    timer = null;
    TanimExec=false;
    var aa = document.getElementById("animationarea");
    aa.value=Tanimation;
    var newanimation = document.getElementById("selanimation");
    newanimation.disabled=false;
}



