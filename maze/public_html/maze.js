/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

$(document).ready(function() {
    var flagWin=true;
    var flagStart=false;
    var xpos=0;
    $("div .boundary").mouseenter(function(){
        $("div .boundary").addClass("youlose");
        flagWin=false;
    });
    $("div .boundary").mouseleave(function(){
        if(!flagStart){
            $("div .boundary").removeClass("youlose");
        }
    });
    $("#start").click(function(){
        if(!flagWin){
            $("div .boundary").removeClass("youlose");
            $("#status").text('Game Started.  Enjoy! (Do not touch boundaries)');
        }
        flagStart=true;
        flagWin=true;
        $("#start").mousemove(function(event0){
            xpos=event0.pageX;
        });
    });
    $("#end").click(function(){
        if(flagStart){
            if(flagWin){
                //alert("You Win! :]");
                $("#status").text("You Win! :]");
            }else{
                //alert("Sorry, You lost. :[");
                $("#status").text("Sorry, You lost. :[");
            }
            flagStart=false;
        }    
    });    
    $(document).mousemove(function(event){
        if(flagStart){
            if(event.pageX < xpos){
                $("div .boundary").addClass("youlose");
                flagWin=false;                
            }
        }
    });
})();

