(function IEF(){
	var init=function(){
		var xhr=new XMLHttpRequest();
		xhr.open("get","init.servlet",true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var jsonObject=eval('('+xhr.responseText+')');
				if(jsonObject.result=="ok"){
					var table=document.getElementById("show");
					var pl=jsonObject.cakelist;
					 var sFeature = "dialogWidth:1200px; dialogHeight:250px;center:yes;help:no;resizable:yes;scroll:auto;status:yes";
					for(let i=0,len=pl.length;i<len;i++){
						pram=new Object();
						let row=table.insertRow(i);
						row.id="row_"+pl[i].cakeId;
						row.class="success";
						row.insertCell(0).appendChild(document.createTextNode(pl[i].cakeId));
						row.insertCell(1).appendChild(document.createTextNode(pl[i].cakeName));
						row.insertCell(2).appendChild(document.createTextNode(pl[i].cakeSize));
						row.insertCell(3).appendChild(document.createTextNode(pl[i].cakeprice));
						var btn1=document.createElement("input");
						btn1.type="button";
						btn1.name="showButtonUpdate";
						btn1.dataset.id=pl[i].cakeId;
						 pram=pl[i].cakeId;
						btn1.id="btn_update";
						btn1.value="详细信息";
						btn1.addEventListener("click",()=>{
							// window.showModalDialog("Cakeprofile.html",pram,sFeature);
							 window.location.href="Cakeprofile.html?"+pram;
						},false);
						var btn2=document.createElement("input");
						btn2.type="button";
						btn2.name="showButtonDelete";
						btn2.dataset.id=pl[i].cakeId;
						
						pram=pl[i];
						btn2.value="购买";
						btn2.addEventListener("click",()=>{
							window.showModalDialog("shop.html",pram,sFeature);
							 //window.location.href="shop.html?"+pram;
						});
						
						
						var cell=row.insertCell(4);
						cell.appendChild(btn1);
						cell.appendChild(btn2);
					}
				
					var  jilu=document.getElementById("jilu");
					jilu.addEventListener("click",()=>{
						window.showModalDialog("shop.html",pram,sFeature);

					})
					var DCURD=document.getElementById("DCURD");
					DCURD.addEventListener("click",()=>{
						window.location.href="mcrud.html";
					})
					var VCURD=document.getElementById("VCURD");
					VCURD.addEventListener("click",()=>{
						alert("DADA");
					})
				}
				
				else{

				}
			}
		};
		xhr.send(null);
	
	}
	window.addEventListener("load",()=>{
		init();
	},false);
})();