package edu.lhs.dao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.lhs.dao.iface.cakeDao;
import edu.lhs.daos.cakedaoitf;
import edu.lhs.entity.cake;
@WebServlet(urlPatterns={"/init.servlet"})
public class Initservlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain; charset=utf-8");
		
        ArrayList<cake> cakelist=new ArrayList<cake>();      
		cakeDao cake=new cakedaoitf();
         cakelist= cake.queryall();
         PrintWriter out=resp.getWriter();
           if(!("".equals(cakelist))){
        	 Map<String,Object> map=new HashMap<String,Object>();
        	 map.put("result", "ok");
        	 map.put("cakelist", cakelist);
        	 String jsonString=JSON.toJSONString(map);
     	out.print(jsonString);
     	out.flush();
     	out.close();
        	
  
        
         }
             
             
		
	}

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(req,resp);
}

}
