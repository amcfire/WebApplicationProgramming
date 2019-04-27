/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

$(document).ready(function() {
    
    var arrayP = new Array(4);
    var arrayP0 = new Array(0,0,0,0);
    var arrayP1 = new Array(0,0,0,0);
    var arrayP2 = new Array(0,0,0,0);
    var arrayP3 = new Array(0,0,0,0);
    arrayP[0]=arrayP0;
    arrayP[1]=arrayP1;
    arrayP[2]=arrayP2;
    arrayP[3]=arrayP3;
    setInitId();
    readArrayFirst();
            
    $("#puzzlearea").children().each(function(idx, e){ 
            var n=idx; 
            var xpos=((n%4)*100)+'px';
            var ypos=(Math.floor(n/4)*100)+'px';
            var bgp= "-" + xpos + " -" + ypos;
//            alert($(e).text());
            $(e).css("left", xpos); 
            $(e).css("top", ypos);
            $(e).css("background-image", "url(background.jpg)");
            $(e).css("background-position", bgp);
        }); 
    $("#puzzlearea").children().addClass("puzzlepiece");
    
    $(".puzzlepiece").mouseenter(function(){
        $(this).addClass("movablepiece");
    });
    
    $(".puzzlepiece").mouseleave(function(){
        $(this).removeClass("movablepiece");
    });

    $(".puzzlepiece").click(function(){
        var s=$(this).attr("id");
        var row=parseInt(s.charAt(1));
        var col=parseInt(s.charAt(3));
        var z=parseInt($(this).text());
        //alert("col "+col+" row "+row+" c "+z);
        //id up
        var ru=row-1;
        if((ru>=0)&&(ru<=3)){
            if(arrayP[ru][col]===0){
                var xpos = col*100;
                var ypos = ru*100;
                arrayP[ru][col]=z;
                arrayP[row][col]=0;
                $(this).css("left", xpos); 
                $(this).css("top", ypos);
                var x=ru;
                var y=col;
                var tid= "X"+x+"Y"+y;
                $(this).attr("id",tid);
                //alert("move up");
            }
        }
        var rd=row+1;
        if((rd>=0)&&(rd<=3)){
            if(arrayP[rd][col]===0){
                var xpos = col*100;
                var ypos = rd*100;
                arrayP[rd][col]=z;
                arrayP[row][col]=0;
                var x=rd;
                var y=col;
                var tid= "X"+x+"Y"+y;
                $(this).attr("id",tid);
                $(this).css("left", xpos); 
                $(this).css("top", ypos);
                //alert("move down");
            }
        }        
        var cl=col-1;
        if((cl>=0)&&(cl<=3)){
            if(arrayP[row][cl]===0){
                var xpos = cl*100;
                var ypos = row*100;
                arrayP[row][cl]=z;
                arrayP[row][col]=0;
                var x=row;
                var y=cl;
                var tid= "X"+x+"Y"+y;
                $(this).attr("id",tid);
                $(this).css("left", xpos); 
                $(this).css("top", ypos);
                //alert("move left");
            }
        }
        var cr=col+1;
        if((cr>=0)&&(cr<=3)){
            if(arrayP[row][cr]===0){
                var xpos = cr*100;
                var ypos = row*100;
                arrayP[row][cr]=z;
                arrayP[row][col]=0;
                var x=row;
                var y=cr;
                var tid= "X"+x+"Y"+y;
                $(this).attr("id",tid);
                $(this).css("left", xpos); 
                $(this).css("top", ypos);
                //alert("move right");
            }
        }
        reviewWin();
    });
    
    $("#shufflebutton").click(function(){
            var norder = random15();
            $("#puzzlearea").children().each(function(idx1, e1){ 
                var m=norder[idx1]; 
                var z=m+1;
                var y=Math.floor(m/4);
                var ypos=(y*100)+'px';
                var x=(m%4);
                var xpos=(x*100)+'px';
                var bgp= "-" + xpos + " -" + ypos;
                $(e1).css("background-position", bgp);
                $(e1).text(z);
            });
            readArrayFirst();
            //alert(arrayP);
    });

    function random15(){
        var result = [];
        for (var i=0; i<15; i++){
            var t1 = (Math.floor(Math.random()*15));
            while((result.indexOf(t1)>=0)||(t1===16)){
                t1 = (Math.floor(Math.random()*15));
            }
            result.push(t1);
        }
//        for (var j=0; j<15; j++){
//            var t2=result[j];
//            alert(t2);
//        }
        return result;
    }
    
    function readArrayFirst(){
         $("#puzzlearea").children().each(function(idx1, e1){ 
             var s=$(e1).attr("id");
             var x=parseInt(s.charAt(1));
             var y=parseInt(s.charAt(3));
             var z = parseInt($(e1).text());
             arrayP[x][y]=z;
            });
         arrayP[3][3]=0;
    }
    
    //alert($('#test').attr('id'));
    
    function setInitId(){
         $("#puzzlearea").children().each(function(idx1, e1){ 
                var m=idx1; 
                var x=Math.floor(m/4);
                var y=(m%4);
                var tid= "X"+x+"Y"+y;
                //alert(tid);
                $(e1).attr("id",tid);
            });
    }
    
    function reviewWin(){
        var win=true;
         $("#puzzlearea").children().each(function(idx1, e1){ 
             var s=$(e1).attr("id");
             var x=parseInt(s.charAt(1));
             var y=parseInt(s.charAt(3));
             var ex=(y+1)+(4*(x));
             var z = parseInt($(e1).text());
             //alert("ex: "+ex+" val: "+z);
             win = win&&(ex===z);
         });
         if(win){
             alert("You Win!!!");
         }
    }
 
})();

