//闭包
var load=(function(){
	var  butl=null,
	  butr=null,
	  butp=null,
	  imglist=null,
	  orgin=['125px','600px'],
	  imgorigin=["125px","800px"],
	     imgx=0,
	     imgTime=300,
       IMGANG=45,
       rotating=false,
       autotime=null,
       autointerval=3000,
       
	 imgALL=createIMG([
	  ["img/1.jpg","img/2.jpg","img/3.jpg","img/4.jpg"],
	  ["img/5.jpg","img/6.jpg","img/7.jpg","img/8.jpg"],
	  ["img/9.jpg","img/10.jpg","img/11.jpg","img/12.jpg"]
	 
	  ]
	);
	
	//闭包可保护变量
function init(){
	butl=$(".butl"),
	butr=$(".butr"),
	butp=$(".butp"),
	imglist=$(".Mbox ul li"),
	configer();
	setEvent();
}

//控制图片角度
function configer(){
	var ang=5,
	aint =-5;
    imglist.transform({origin:orgin});
	imglist.each(function(i){
		var $this=$(this);
		$this.transform({rotate:aint+(i*ang)+"deg"})
	})
}
//on 包括bind
 function setEvent(){
 	butl.bind("click",function(){
 	anigo(-1);
 	//alert(imgALL[0][0])
 		//return false;
 	});
 	 	butr.bind("click",function(){
 	 		anigo(1);
 		//return false;
 	});
 	 	butp.bind("click",function(){
 	 		var play="play";
 	 		var pause="pause";
 	 		but=$(this);
 	 		if(but.html()=="play"){
 	 			but.html(pause);
 	 			anigo(1)
 	 			autotime=setInterval(function(){
 	 				anigo(1)},1000
 	 			);
 	 		}
 	 		else
 	 		{
 	 			but.html(play);
 	 			clearInterval(autotime);
 	 		}
 		//return false;
 	});
 	 	
 }
 function createIMG(arr){
 	var imgArr=[];
 	for(var i in arr){
 		imgArr[i]=[];
 		for(var x in arr[i]){
 			imgArr[i][x]=new Image();
 			imgArr[i][x].src=arr[i][x];
 		}
 	}
 	return imgArr;
 }
 function anigo(d){
   if(rotating)
   return false;
   rotating=true;
   
 	imgx=imgx+d;
 	if(imgx>imgALL.length-1){
 		imgx=0;
 	}
 	else if(imgx<0){
 		imgx=imgALL.length-1;
 		
 		
 	}
 	//tupianzu
 	imglist.each(function(i){
 		//donghuazairu
 	
 		var thisItme=$(this);
 		var thisimg=thisItme.children("img");
 		var targeIMG=$(imgALL[imgx][i]);//新加入图片
 	    var thistime=(d===1)?imgTime*i:imgTime*(imglist.length-1-i);
 		
 		thisItme.append(targeIMG);
 		thisimg.transform({origin:imgorigin});
 		
 		targeIMG.transform({origin:imgorigin,rotate:(-d)*IMGANG+"deg"});
 		setTimeout(function(){
 			
 		
 		   thisimg.animate({rotate:IMGANG*d+"deg"});
 	       targeIMG.animate({rotate:"0deg"},500,function(){
 	       	thisimg.remove();
 	       	if((i==0&&d==-1)||(i==imglist.length-1&&d==1)){
 	       		rotating=false;
 	       	};
 	       });
             },thistime);
 		
 		
 	})
 	
 }
   
return init;



})();
load();
