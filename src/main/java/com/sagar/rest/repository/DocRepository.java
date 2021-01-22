package com.sagar.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sagar.rest.model.Doc;

public interface DocRepository extends MongoRepository<Doc, String>{

}