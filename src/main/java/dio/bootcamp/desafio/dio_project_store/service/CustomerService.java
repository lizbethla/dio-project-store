package dio.bootcamp.desafio.dio_project_store.service;

import java.util.List;

import dio.bootcamp.desafio.dio_project_store.model.Customer;

public interface CustomerService {
    Customer findById(Long id);

    Customer create(Customer customerToCreate);

    List<Customer> findAll();

    Customer update(Long id, Customer customerToUpdate);

    void delete(Long id);
}
