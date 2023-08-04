package com.demo.springRest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.springRest.models.Students;

public interface StudentRepository extends MongoRepository<Students,Integer>{

}
