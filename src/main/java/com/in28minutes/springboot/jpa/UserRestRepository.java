package com.in28minutes.springboot.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserRestRepository extends CrudRepository<UserJpa, Integer> {

}
