package com.example.carservice.service;

import com.example.carservice.model.DTO.ServiceDTO;
import com.example.carservice.model.entity.Servicee;
import com.example.carservice.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceeService {
    @Autowired
    ServiceRepository serviceRepository;

    public Servicee insertService(ServiceDTO serviceDTO){
        ModelMapper mapper = new ModelMapper();
        Servicee service = mapper.map(serviceDTO,Servicee.class);
        serviceRepository.save(service);
        return service;
    }
}
