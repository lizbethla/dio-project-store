package dio.bootcamp.desafio.dio_project_store.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.bootcamp.desafio.dio_project_store.model.Customer;
import dio.bootcamp.desafio.dio_project_store.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        var customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customerToCreate){
        var customerCreated = customerService.create(customerToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(customerCreated.getId())
                       .toUri();
        return ResponseEntity.created(location).body(customerCreated);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customerList = customerService.findAll();
        return ResponseEntity.ok(customerList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customerToUpdate) {
        var customerUpdated = customerService.update(id, customerToUpdate);
        return ResponseEntity.ok(customerUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
