package edu.lhs.entity;

public class Vip {
private int Vnumber;
private String Vzh;
private String Vpasw;
private String Vname;
private int Vjf;
private String Vbirth;
@Override
public String toString() {
	return "Vip [Vnumber=" + Vnumber + ", Vzh=" + Vzh + ", Vpasw=" + Vpasw + ", Vname=" + Vname + ", Vjf=" + Vjf
			+ ", Vbirth=" + Vbirth + ", Vadd=" + Vadd + "]";
}
private String Vadd;
public int getVnumber() {
	return Vnumber;
}
public void setVnumber(int i) {
	Vnumber = i;
}
public String getVzh() {
	return Vzh;
}
public void setVzh(String vzh) {
	Vzh = vzh;
}
public String getVpasw() {
	return Vpasw;
}
public void setVpasw(String vpasw) {
	Vpasw = vpasw;
}
public String getVname() {
	return Vname;
}
public void setVname(String vname) {
	Vname = vname;
}
public int getVjf() {
	return Vjf;
}
public void setVjf(int vjf) {
	Vjf = vjf;
}
public String getVbirth() {
	return Vbirth;
}
public void setVbirth(String vbirth) {
	Vbirth = vbirth;
}
public String getVadd() {
	return Vadd;
}
public void setVadd(String vadd) {
	Vadd = vadd;
}
}
