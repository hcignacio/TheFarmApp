package com.chickentest.chickentestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chickentest.chickentestapp.model.Egg;

@RepositoryRestResource
public interface EggRepository extends JpaRepository<Egg, Long>{
}
