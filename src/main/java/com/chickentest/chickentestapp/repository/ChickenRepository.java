package com.chickentest.chickentestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chickentest.chickentestapp.model.Chicken;

@RepositoryRestResource
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}
