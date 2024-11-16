package dio.bootcamp.desafio.dio_project_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dio.bootcamp.desafio.dio_project_store.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
