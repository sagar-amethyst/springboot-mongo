package com.sagar.rest.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "doc")
public class Doc {
    @Id
    @Field
    private String id;

    @Field
    private String system;

    @Field
    private String client;
    
    @Field
    private String service;
    @Field
    private String root;

    @Field
    private Binary file;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Binary getFile() {
		return file;
	}

	public void setFile(Binary file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", system=" + system + ", client=" + client + ", service=" + service + ", root=" + root
				+ ", file=" + file + "}";
	}

	
}
