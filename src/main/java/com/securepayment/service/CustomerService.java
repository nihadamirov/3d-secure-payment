package com.securepayment.service;

import com.securepayment.dto.CustomerDTO;
import com.securepayment.entity.Customer;
import com.securepayment.exception.ResourceNotFoundException;
import com.securepayment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    private Customer convertToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.id());
        customer.setFirstName(customerDTO.firstname());
        customer.setLastName(customerDTO.lastname());
        customer.setEmail(customerDTO.email());
        customer.setPhone(customerDTO.phone());
        return customer;
    }

    private CustomerDTO convertToDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = convertToEntity(customerDTO);
        Customer saveCustomer = customerRepository.save(customer);

        return convertToDto(saveCustomer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        modelMapper.map(customerDTO, customer);
        Customer updateCustomer = customerRepository.save(customer);
        return convertToDto(updateCustomer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));


        return convertToDto(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found with id " + id));
        customerRepository.delete(customer);
    }
}
