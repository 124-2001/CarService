package com.example.carservice.repository;

import com.example.carservice.model.entity.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Servicee,Integer> {
    Servicee findByName(String name);
}
