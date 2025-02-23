package com.preworkspringredis.repository;

import com.preworkspringredis.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer",nativeQuery = true)
    List<Customer> findAllCustomers();

}
