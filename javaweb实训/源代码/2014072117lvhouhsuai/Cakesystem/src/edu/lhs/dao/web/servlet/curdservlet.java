package edu.lhs.dao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.lhs.dao.iface.cakeDao;
import edu.lhs.daos.cakedaoitf;
import edu.lhs.entity.cake;
@WebServlet(urlPatterns={"/curd"})
public class curdservlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain; charset=utf-8");
		   cakeDao dao=new cakedaoitf();
		   String pram=	req.getParameter("pram");
	    
           if(pram.equals("tianjia")){
        	   cake cake=new cake();
        	  cake.setCakeId( req.getParameter("CakeId"));
        	  cake.setCakeName(req.getParameter("Cname"));
        	  cake.setCakeprice(req.getParameter("Cprice"));
        	  cake.setCakeSize(req.getParameter("Csize"));
        	  cake.setCakeType(Integer.parseInt(req.getParameter("Ctype")));
        	  System.out.println(cake.toString());
        	  if(dao.add(cake)){
        		  req.getRequestDispatcher("mcrud.html").forward(req, resp);
        	  }
        	  else{
        		  System.out.println("cuole");
        	  }
        	  }
           if(pram.equals("xiugai")){
        	   
        	   cake cake=new cake();
         	  cake.setCakeId( req.getParameter("CakeId"));
         	  cake.setCakeName(req.getParameter("Cname"));
         	  cake.setCakeprice(req.getParameter("Cprice"));
         	  cake.setCakeSize(req.getParameter("Csize"));
        	  cake.setCakeType(Integer.parseInt(req.getParameter("Ctype")));
         	  System.out.println(cake.toString());
         	  if(dao.updata(cake)){
         		 req.getRequestDispatcher("mcrud.html").forward(req, resp);
         	  }
         	  else{
         		  System.out.println("cuole");
         	  }
           }
           else{
			     
			       String a=  pram.split("_")[0];
			       String s=pram.split("_")[1];
			       System.out.println(a+s);
			       if("s".equals(a)){
			      	if(dao.dele(s)){
			      		PrintWriter out1=resp.getWriter();
						HashMap<String, Object> map1=new HashMap<String, Object>() ;
						map1.put("result", "ok");
						
					 String jsonString=JSON.toJSONString(map1);
						 out1.print(jsonString);
					 
					     	out1.flush();
					   	out1.close();
			      	}
			      	  else{
			      		  System.out.println("cuole");
			      	  }
			       }
           }
	}

}
