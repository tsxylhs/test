function mag(){
	   // var pram=document.getElementById("ty")
		// var zh=document.getElementById('VZH').value;
		// var name=document.getElementById("Vname").value;
		//var psw=document.getElementById("Vpasw").value;
		var type1=document.getElementById("choose").value;
		//var vbrith=document.getElementById("Vbith").value;
		//var VAdd=document.getElementById("Vadd").value;
		alert(type1);
		var xhr=new XMLHttpRequest();
		if(type1=="VipZH"){
		 var zh=document.getElementById('VZH').value;
		 var name=document.getElementById("Vname").value;
		 var psw=document.getElementById("Vpasw").value;
		 var vbrith=document.getElementById("Vbith").value;
		 var VAdd=document.getElementById("Vadd").value;
		xhr.open("get","mag.servlet?pram=VipZH&Vzh="+zh+"&Vpasw="+psw+"&Vname="+name+"&Vbirth="+vbrith+"&Vadd="+VAdd+"",true);
		}
		if(type1=="MZC"){
			 var zh=document.getElementById('inputEmail').value;
		     var name=document.getElementById("name").value;
		    var psw=document.getElementById("inputPassword").value;
			xhr.open("get","mag.servlet?pram=MZC&MZH="+zh+"&Mpasw="+psw+"&Mname="+name+"",true);

		}
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

