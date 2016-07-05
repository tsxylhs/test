package edu.lhs.entity;

public class cake {
@Override
	public String toString() {
		return "cake [CakeName=" + CakeName + ", CakeId=" + CakeId + ", CakeSize=" + CakeSize + ", Cakeprice="
				+ Cakeprice + ", CakeType=" + CakeType + "]";
	}
private String CakeName;
private String CakeId;
private String CakeSize;
private String Cakeprice;
private int CakeType;
public String getCakeName() {
	return CakeName;
}
public void setCakeName(String cakeName) {
	CakeName = cakeName;
}
public String getCakeId() {
	return CakeId;
}
public void setCakeId(String cakeId) {
	CakeId = cakeId;
}
public String getCakeSize() {
	return CakeSize;
}
public void setCakeSize(String cakeSize) {
	CakeSize = cakeSize;
}
public String getCakeprice() {
	return Cakeprice;
}
public void setCakeprice(String cakeprice) {
	Cakeprice = cakeprice;
}
public int getCakeType() {
	return CakeType;
}
public void setCakeType(int cakeType) {
	CakeType = cakeType;
}
}
