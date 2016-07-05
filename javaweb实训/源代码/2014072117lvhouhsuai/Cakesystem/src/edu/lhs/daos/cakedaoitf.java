package edu.lhs.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.lhs.dao.iface.cakeDao;
import edu.lhs.dbutil.DbConnection;
import edu.lhs.entity.Vip;
import edu.lhs.entity.adm;
import edu.lhs.entity.cake;

//查询蛋糕
public class cakedaoitf implements cakeDao {
	//登陆验证
	public boolean check(adm adm,Vip vip){
	String sql="select Vpasw Vzh from vip where Vpasw='"+vip.getVpasw()+"'and Vzh='"+vip.getVzh()+"'";
	String sql1="select Apasw  Azh from Adm where Apasw='"+adm.getApasw()+"'and Azh='"+adm.getAzh()+"'";
	Connection connection=DbConnection.getConnection();
	try {
		Statement stmt =connection.createStatement();
		if(vip.getVzh()!=null){
		ResultSet rs=stmt.executeQuery(sql);
		if(rs!=null){
			return true;
		}
		}
		if(adm.getAzh()!=null){
			ResultSet rs=stmt.executeQuery(sql1);
			if(rs!=null){
				return true;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		DbConnection.closeConnection(connection);
	}	
		return false;	
	}
	//查询蛋糕
	public ArrayList<cake> queryall(){
		ArrayList<cake> cakelist=new ArrayList<cake>();
		String sql="select *from cake";
		Connection connection=DbConnection.getConnection();
	   try {
		PreparedStatement pstm=connection.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			cake cake=new cake();
			cake.setCakeName(rs.getString(1));
			cake.setCakeId(rs.getString(2));
			cake.setCakeSize(rs.getString(3));
			cake.setCakeprice(rs.getString(4));
			cake.setCakeType( Integer.parseInt(rs.getString(5)));
			cakelist.add(cake);
			
		}
		return cakelist;		
	} catch (SQLException e) {
		System.out.println("数据库连接失败！");
		e.printStackTrace();
	}
	   finally{
			DbConnection.closeConnection(connection);
		}
	
		
		return null;
		
	}
	//vip会员注册
	public boolean VipZh(Vip vip){
		Connection connection=DbConnection.getConnection();
		String sql="insert into vip values(?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1, vip.getVnumber());
		     pstm.setString(2,vip.getVzh());
		     pstm.setString(3, vip.getVpasw());
		     pstm.setString(4, vip.getVname());
		    pstm.setInt(5, vip.getVjf());
		    pstm.setString(6,vip.getVbirth());
		    pstm.setString(7, vip.getVadd());
		    int f=0;
		    f=pstm.executeUpdate();
		    if(f!=0){
		    	return true;
		    	
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
				DbConnection.closeConnection(connection);
			}
		return false;
			
		
	}
	//管理员注册
	public boolean MZC(adm adm){
		Connection connection=DbConnection.getConnection();
		String sql="insert into Adm values(?,?,?)";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setString(1, adm.getAname());
			pstm.setString(2, adm.getAzh());
			pstm.setString(3, adm.getApasw());
			if(pstm.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
				DbConnection.closeConnection(connection);
			}
		
		
		return false;
		
	}

	public boolean add(cake cake){
		Connection connection=DbConnection.getConnection();
		String sql="insert into Cake  values(?,?,?,?,?)";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setString(1, cake.getCakeName());
			pstm.setString(2, cake.getCakeId());
			pstm.setString(3, cake.getCakeSize());
			pstm.setString(4, cake.getCakeprice());
			pstm.setInt(5, cake.getCakeType());
			int i=0;
			i=pstm.executeUpdate();
			if(i!=0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
				DbConnection.closeConnection(connection);
			}
		
		return false;
		
	}
	public boolean updata(cake cake){
		Connection connection=DbConnection.getConnection();
		String sql="update cake set CakeName=?,CakeSize=?,Cakeprice=?,CakeType=? where CakeId=? ";
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setString(1, cake.getCakeName());
			pstm.setString(2, cake.getCakeSize());
			pstm.setString(3, cake.getCakeprice());
			pstm.setInt(4, cake.getCakeType());
			pstm.setString(5, cake.getCakeId());
			int i=0;
			i=pstm.executeUpdate();
			if(i!=0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
				DbConnection.closeConnection(connection);
			}
		
		return false;
		
	}
	public boolean dele(String s){
		Connection connection=DbConnection.getConnection();
		Statement stat=null;
		int rs=0;
		String sql = "DELETE FROM cake WHERE  CakeId='"+s+"'";
			try {
				stat = connection.createStatement();
				 rs = stat.executeUpdate(sql);
				 if(rs!=0){
					 return true;
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally{
					DbConnection.closeConnection(connection);
				}
			
			return false;
			
		
		
	}

}
