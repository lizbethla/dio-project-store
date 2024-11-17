package dio.bootcamp.desafio.dio_project_store.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dio.bootcamp.desafio.dio_project_store.model.Customer;
import dio.bootcamp.desafio.dio_project_store.repository.CustomerRepository;
import dio.bootcamp.desafio.dio_project_store.service.CustomerService;
import dio.bootcamp.desafio.dio_project_store.service.exception.BusinessException;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Customer create(Customer customerToCreate) {
        return customerRepository.save(customerToCreate);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Long id, Customer customerToUpdate) {
        Customer customer = this.findById(id);
        if (customer.getId().equals(customerToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }
        customer.setFirstName(customerToUpdate.getFirstName());
        customer.setLastName(customerToUpdate.getLastName());
        customer.setEmail(customerToUpdate.getEmail());
        return this.customerRepository.save(customer);
    }


    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
    
    
    
}
