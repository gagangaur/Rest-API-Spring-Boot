package com.spring.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.restapi.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	
}
