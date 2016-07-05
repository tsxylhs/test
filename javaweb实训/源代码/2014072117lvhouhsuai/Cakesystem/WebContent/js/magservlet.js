


function mag(){
		 var zh=document.getElementById('inputEmail').value;
		var psw=document.getElementById("inputPassword").value;
		var type1=document.getElementById("choose").value;
		alert(type1);
		var xhr=new XMLHttpRequest();
		xhr.open("get","mag.servlet?pram=login&zh="+zh+"&psw="+psw+"&choose="+type1+"",true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var jsonObject=eval('('+xhr.responseText+')');
				if(jsonObject.result=="adm"){
					
					//var p=document.getElementById("adm");
					var data=jsonObject.result+"?"+jsonObject.adm;
					window.location.href="index.html?"+data;
					//p.insertAdjacentHTML("beforeEnd","<h2>"+data+"</h2>");
				}
				if(jsonObject.result=="vip"){
					//zalert(dddd);
					//var p=document.getElementById("adm");
					var data=jsonObject.result+"?"+jsonObject.vip;
					
					//p.insertAdjacentHTML("beforeEnd","<h2>"+data+"</h2>");
					window.location.href="index.html?"+data;
				}
				else{
					var p=document.getElementById("adm");
					p.insertAdjacentHTML("beforeEnd","<h2 >未登录</h2>");
				}
			}
			
		};
		xhr.send();
	}

