package com.sagar.rest.model;

public class BusinessObject {
private	String businessObject;
private String area;
private String personResponsible;
private String lastOnBoardedBy;
public String getBusinessObject() {
	return businessObject;
}
public void setBusinessObject(String businessObject) {
	this.businessObject = businessObject;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getPersonResponsible() {
	return personResponsible;
}
public void setPersonResponsible(String personResponsible) {
	this.personResponsible = personResponsible;
}
public String getLastOnBoardedBy() {
	return lastOnBoardedBy;
}
public void setLastOnBoardedBy(String lastOnBoardedBy) {
	this.lastOnBoardedBy = lastOnBoardedBy;
}
public BusinessObject(String businessObject, String area, String personResponsible, String lastOnBoardedBy) {
	super();
	this.businessObject = businessObject;
	this.area = area;
	this.personResponsible = personResponsible;
	this.lastOnBoardedBy = lastOnBoardedBy;
}
@Override
public String toString() {
	return "BusinessObject [businessObject=" + businessObject + ", area=" + area + ", personResponsible="
			+ personResponsible + ", lastOnBoardedBy=" + lastOnBoardedBy + "]";
}
	
	
}
