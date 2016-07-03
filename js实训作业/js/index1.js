var chess=document.getElementById("chess");
var context=chess.getContext("2d");
var chessboard=[];
var me=true;
var chushihua=function(){
for(var z=0;z<15;z++){
	chessboard[z]=[];
	for(var v=0;v<15;v++){
		chessboard[z][v]=0;//代表没有骡子
	}
}
}
context.strokeStyle="black";
window.onload=function(){
	huaqipan();
	chushihua();
	
}
var huaqipan=function(){
for(var i=0;i<15;i++){
context.moveTo(15+i*30,15);
context.lineTo(15+i*30,435);
context.stroke();
context.moveTo(15,15+i*30);
context.lineTo(435,15+i*30);
context.stroke();

}
}

var oneStep=function(i,j,me){
	context.beginPath();
	context.arc(15+i*30,15+j*30,13,0,2*Math.PI);
	context.closePath();
	
	var gardient=context.createRadialGradient(15+i*30+2,15+j*30-2,13,15+i*30+2,15+j*30-2,0);
	if(me){
	gardient.addColorStop(0,"#0A0A0A");
	gardient.addColorStop(1,"#636766");
	}
	else{
		gardient.addColorStop(0,"#d1d1d1");
	gardient.addColorStop(1,"#f9f9f9");
	}
	context.fillStyle=gardient;
	context.fill();//填充
	
}
chess.onclick=function(e){
	
	var x =e.offsetX;
	
	var y=e.offsetY;
	 var i=Math.floor(x/30);
	 var j=Math.floor(y/30);
//	  oneStep(i,j,me);
//	  alert(i);
//	  alert(j);
	//  alert(chessboard[i][j])
	 //if(chessboard[i][j] == 0){
	 oneStep(i,j,me);
	
	 me=!me;
	 

}