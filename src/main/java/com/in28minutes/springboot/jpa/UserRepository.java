package com.in28minutes.springboot.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users",collectionResourceRel = "users")
public interface UserRepository extends PagingAndSortingRepository<UserJpa, Integer> {

}
