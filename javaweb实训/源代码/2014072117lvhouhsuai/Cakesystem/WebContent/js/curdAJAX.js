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
					// var sFeature = "dialogWidth:1200px; dialogHeight:250px;center:yes;help:no;resizable:yes;scroll:auto;status:yes";
					for(let i=0,len=pl.length;i<len;i++){
						pram=new Object();
						let row=table.insertRow(i);
						row.id=pl[i].cakeId;
						//row.class="success";
						row.insertCell(0).appendChild(document.createTextNode(pl[i].cakeId));
						row.insertCell(1).appendChild(document.createTextNode(pl[i].cakeName));
						row.insertCell(2).appendChild(document.createTextNode(pl[i].cakeSize));
						row.insertCell(3).appendChild(document.createTextNode(pl[i].cakeprice));
						var btn1=document.createElement("input");
						btn1.type="button";
						btn1.name="showButtonUpdate";
						btn1.dataset.id=pl[i].cakeId;
						 pram=pl[i].cakeId;
						btn1.id=pl[i].cakeId;
						btn1.value="修改";
						btn1.addEventListener("click",()=>{
							   var lg=document.getElementById("LG");
							   lg.style.display="none";
					document.getElementById("xiugai").style.display="block";
							document.getElementById("zh").value=pl[i].cakeId;
							document.getElementById("Dname").value=pl[i].cakeName;
							document.getElementById("Dcc").value=pl[i].cakeSize;
						  document.getElementById("price").value=pl[i].cakeprice;
						  document.getElementById("Ctype").value=pl[i].cakeType;
						});
						var btn2=document.createElement("input");
						btn2.type="button";
						btn2.name="showButtonDelete";
						btn2.id="s_"+pl[i].cakeId;
						btn2.value="删除";
						btn2.addEventListener("click",()=>{
							alert(pl[i].cakeId);
							var xhr1=new XMLHttpRequest();
							xhr1.open("get","curd?pram="+"s_"+pl[i].cakeId+"",true);
							xhr1.onreadystatechange=function(){
								if(xhr1.readyState==4&&xhr.status==200){
									var jsonObject=eval('('+xhr1.responseText+')');
									if(jsonObject.result=="ok"){
										window.location.href="mcrud.html";
										}
									}
								
									}
							xhr1.send();
						});
						
						
						var cell=row.insertCell(4);
						cell.appendChild(btn1);
						cell.appendChild(btn2);
					}
				
				
				
				
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