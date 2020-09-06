package com.spring.demo.customer;

import com.spring.demo.customer.domain.Customer;
import com.spring.demo.customer.entity.AddressEntity;
import com.spring.demo.customer.entity.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Optional<Customer> getCustomerById(Long customerId) {
        log.info("Fetching customer by id: {}", customerId);
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);
        return customerEntity.map(customer -> modelMapper.map(customer, Customer.class));
    }

    public Customer create(Customer customer) {
        try {
            log.info("Creating a new customer with emailAddress: {}", customer.getEmailAddress());
            CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
            CustomerEntity createdCustomer = customerRepository.save(customerEntity);
            return modelMapper.map(createdCustomer, Customer.class);
        }catch (DataIntegrityViolationException e){
            log.error("Error creating customer : {}", e.getMessage());
            throw e;
        }

    }

    public Customer update(Customer customer) {
        log.info("Updating a customer with id: {}", customer.getId());
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customer.getId());
        if(optionalCustomer.isEmpty()) {
            log.error("Unable to update customer by id {}",  customer.getId());
            throw new RuntimeException("Customer does not exists");
        }

        CustomerEntity existingCustomer = optionalCustomer.get();
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());

        List<AddressEntity> addresses = modelMapper.map(customer.getAddresses(), new TypeToken<List<AddressEntity>>() {}.getType());
        existingCustomer.setAddresses(addresses);

        CustomerEntity updatedCustomerEntity = customerRepository.save(existingCustomer);
        return modelMapper.map(updatedCustomerEntity, Customer.class);
    }

    public List<Customer> findAll(Pageable pageable) {
        Page<CustomerEntity> results = customerRepository.findAll(pageable);
        List<CustomerEntity> customers = results.getContent();
        return modelMapper.map(customers, new TypeToken<List<Customer>>(){}.getType());
    }


    public void deleteCustomer(Long customerId) {
        try {
            customerRepository.deleteById(customerId);
        } catch (EmptyResultDataAccessException e) {
            log.error("Unable to delete customer by id {}", customerId);
            throw new RuntimeException("Customer does not exists");
        }
    }
}
