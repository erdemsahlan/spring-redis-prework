package com.preworkspringredis.services;

import com.preworkspringredis.dto.CustomerDto;
import com.preworkspringredis.models.Customer;
import com.preworkspringredis.repository.ICustomerRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final ICustomerRepo customerRepo;

    public CustomerService(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Cacheable(value = "userInfo")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers = customerRepo.findAllCustomers();
        return customers;
    }
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName( customerDto.getName() );
        customer.setAddress( customerDto.getAddress() );
        customer.setCustomerEmail( customerDto.getCustomerEmail() );
        customer.setBirthday(customerDto.getBirthday());
        customer.setPhone( customerDto.getPhone() );
        customerRepo.save(customer);
        return customerDto;
    }
}
