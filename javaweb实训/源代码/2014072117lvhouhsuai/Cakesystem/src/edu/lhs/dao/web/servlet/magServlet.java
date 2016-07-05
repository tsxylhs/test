package edu.lhs.dao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sun.glass.ui.Window;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.javafx.collections.MappingChange.Map;

import edu.lhs.dao.iface.cakeDao;
import edu.lhs.daos.cakedaoitf;
import edu.lhs.entity.Vip;
import edu.lhs.entity.adm;
@WebServlet(urlPatterns={"/mag.servlet"})
public class magServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		      
		          cakeDao dao=new cakedaoitf();
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html; charset=utf-8");
				String pram=req.getParameter("pram");
				System.out.println(pram);
				
				//µÇÂ½
			    	if("login".equals(pram)){
					String choose=req.getParameter("choose");
					System.out.println(choose);
					if("vip".equals(choose)){
						Vip vip1=new Vip();
						vip1.setVzh(req.getParameter("zh"));
						vip1.setVpasw(req.getParameter("psw"));
						System.out.println(vip1.toString());
						adm admnull=new adm();
				 	
				    	if(dao.check(admnull, vip1)){
				 		PrintWriter out1=resp.getWriter();
						HashMap<String, Object> map1=new HashMap<String, Object>() ;
						map1.put("result", "vip");
						map1.put("vip", vip1.getVzh());
					 String jsonString=JSON.toJSONString(map1);
						 out1.print(jsonString);
					 
					     	out1.flush();
					   	out1.close();
					     	 // RequestDispatcher   requestDispatcher=req.getRequestDispatcher("http://localhost:8080/Cakesystem/index.html");   			
					}
						
					}
					if("adm".equals(choose)){
						adm adm1=new adm();
						adm1.setAzh(req.getParameter("zh"));
						adm1.setApasw(req.getParameter("psw"));
						System.out.println(adm1.toString());
						Vip vipnull=new Vip();
						if(dao.check(adm1,vipnull)){
							PrintWriter out1=resp.getWriter();
							HashMap<String, Object> map1=new HashMap<String, Object>() ;
							map1.put("result", "adm");
							map1.put("adm", adm1.getAzh());
							 String jsonString=JSON.toJSONString(map1);
							 out1.print(jsonString);
						     	out1.flush();
						     	out1.close();
						     //	 RequestDispatcher   requestDispatcher=req.getRequestDispatcher("http://localhost:8080/Cakesystem/index.html"); 				
						}
					}
				}
					//¹ÜÀíÔ±×¢²á
				if("MZC".equals(pram)){
					adm adm=new adm();
				adm.setAzh(req.getParameter("MZH"));
				adm.setAname(req.getParameter("Mname"));
				adm.setApasw(req.getParameter("Mpasw"));
				System.out.println(adm.toString());
				if(dao.MZC(adm)){
					PrintWriter out = resp.getWriter();
					HashMap<String, Object> map1=new HashMap<String, Object>() ;
					map1.put("result", "adm");
					map1.put("adm", adm.getAzh());
					 String jsonString=JSON.toJSONString(map1);
					 out.print(jsonString);
				     	
				    // RequestDispatcher   requestDispatcher=req.getRequestDispatcher("http://localhost:8080/Cakesystem/index.html"); 
				     out.flush();
				     	out.close();
				}
				else{
					System.out.println("youcuo");
				}
				}
				//vip×¢²á
				if("VipZH".equals(pram)){
					Vip vip=new Vip();
					int i=(int)(Math.random()*1000);;
					i++;
					vip.setVnumber(i++);
					vip.setVjf(1);
					vip.setVzh(req.getParameter("Vzh"));
					vip.setVpasw(req.getParameter("Vpasw"));
					vip.setVname(req.getParameter("Vname"));
					vip.setVbirth((String)req.getParameter("Vbrith"));
					vip.setVadd(req.getParameter("Vadd"));
					System.out.println(vip.toString());
					
					if(dao.VipZh(vip)){
						PrintWriter out1=resp.getWriter();
						HashMap<String, Object> map1=new HashMap<String, Object>() ;
						map1.put("result", "vip");
						map1.put("vip", vip.getVzh());
						 String jsonString=JSON.toJSONString(map1);
						 out1.print(jsonString);
					     	out1.flush();
					     	out1.close();
					     //	 RequestDispatcher   requestDispatcher=req.getRequestDispatcher("http://localhost:8080/Cakesystem/index.html"); 				
					    	}
					else{
						System.out.println("youcuo");
					}
				}
				
				
				
				
			

			
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
