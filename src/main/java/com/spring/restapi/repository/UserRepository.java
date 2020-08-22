package com.spring.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}
