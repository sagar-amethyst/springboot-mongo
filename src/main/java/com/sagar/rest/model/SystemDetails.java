package com.sagar.rest.model;

import java.util.List;

public class SystemDetails {
private	String name;

private List<String> api;
private String root;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getApi() {
	return api;
}
public void setApi(List<String> api) {
	this.api = api;
}
public String getRoot() {
	return root;
}
public void setRoot(String root) {
	this.root = root;
}
public SystemDetails(String name, List<String> api, String root) {
	super();
	this.name = name;
	this.api = api;
	this.root = root;
}
@Override
public String toString() {
	return "{name=" + name + ", api=" + api + ", root=" + root + "}";
}

	
	
}
