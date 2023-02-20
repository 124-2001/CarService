package com.example.carservice.service;

import com.example.carservice.exception.NotFoundException;
import com.example.carservice.model.DTO.CustomerDTO;
import com.example.carservice.model.DTO.OrderDTO;
import com.example.carservice.model.DTO.ServiceDTO;
import com.example.carservice.model.DTO.StaffDTO;
import com.example.carservice.model.entity.*;
import com.example.carservice.model.enums.StatusOrder;
import com.example.carservice.repository.CustomerRepository;
import com.example.carservice.repository.OrderRepository;
import com.example.carservice.repository.ProductRepository;
import com.example.carservice.repository.ServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ServiceeService serviceeService;

    @Transactional
    public Order insertOrder(OrderDTO newOrder) {
        ModelMapper mapper = new ModelMapper();
        Order order = new Order();
        CustomerDTO customerDTO = newOrder.getCustomer();
        if (customerRepository.findByPhone(customerDTO.getPhone()) == null) {
            Customer newCustomer = mapper.map(customerDTO, Customer.class);
            customerRepository.save(newCustomer);
            order.setCustomer(newCustomer);
        } else {
            order.setCustomer(customerRepository.findByPhone(customerDTO.getPhone()));
        }

        if (newOrder.getProducts() == null) {
            throw new NotFoundException("Chua dien thong tin xe");
        } else {
            Set<Product> products = newOrder.getProducts().stream().map(productDTO -> mapper.map(productDTO, Product.class)).collect(Collectors.toSet());
            productRepository.saveAll(products);
            order.setProducts(products);
        }

        order.setNote(newOrder.getNote());
        Date currentDate = new Date(System.currentTimeMillis());
        order.setTimeOrder(currentDate);

        order.setStatusOrder(StatusOrder.PROCESSING);
        orderRepository.save(order);
        return order;
    }

    @Transactional
    public Order insertStaffInOrder(Order order, Set<StaffDTO> staffsDTO) {
        ModelMapper mapper = new ModelMapper();
        if (orderRepository.findByCustomerAndProductsAndStatusOrder(order.getCustomer(), order.getProducts(),StatusOrder.PROCESSING) == null) {
            throw new NotFoundException("Khong tim thay don hang cua khach hang");
        }
        Order findOrder = orderRepository.findByCustomerAndProductsAndStatusOrder(order.getCustomer(), order.getProducts(),StatusOrder.PROCESSING);
        Set<Staff> staffs = staffsDTO.stream().map(staffDTO -> mapper.map(staffDTO, Staff.class)).collect(Collectors.toSet());
        findOrder.setStaffs(staffs);
        orderRepository.save(findOrder);
        return findOrder;
    }

    @Transactional
    public Order updateService(Order order, Set<ServiceDTO> servicesDTO){
        ModelMapper mapper = new ModelMapper();
//        String assignment ="";
        if (orderRepository.findByCustomerAndProductsAndStatusOrder(order.getCustomer(), order.getProducts(),StatusOrder.PROCESSING) == null) {
            throw new NotFoundException("Khong tim thay don hang cua khach hang");
        }
        Order findOrder = orderRepository.findByCustomerAndProductsAndStatusOrder(order.getCustomer(), order.getProducts(),StatusOrder.PROCESSING);
        for (ServiceDTO serviceDTO : servicesDTO) {
            if(serviceRepository.findByName(serviceDTO.getName())==null){
                serviceeService.insertService(serviceDTO);
            }
        }
        Set<Servicee> servicees = servicesDTO.stream().map(serviceDTO -> mapper.map(serviceDTO,Servicee.class)).collect(Collectors.toSet());
        findOrder.setServicees(servicees);
        findOrder.setTotalPrice(totalPrice(servicees));
        orderRepository.save(findOrder);
        return findOrder;
    }

    public float totalPrice(Set<Servicee> servicees){
        float price =0;
        for (Servicee servicee : servicees) {
            price+= servicee.getPrice();
        }
        return price;
    }
}
