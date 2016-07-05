package edu.lhs.dao.iface;

import java.util.ArrayList;

import edu.lhs.entity.Vip;
import edu.lhs.entity.adm;
import edu.lhs.entity.cake;

public interface cakeDao {
//注册与登陆	
public ArrayList<cake> queryall();
public boolean VipZh(Vip vip);
public boolean MZC(adm adm);
public boolean check(adm adm,Vip vip);
//蛋糕的增删改查
public boolean add(cake cake);
public boolean updata(cake cake);
public boolean dele(String a);

}
