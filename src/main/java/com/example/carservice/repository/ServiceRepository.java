package com.example.carservice.repository;

import com.example.carservice.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer> {
    Services findByName(String name);
}
