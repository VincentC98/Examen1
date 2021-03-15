package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
    Customer findCustomerByCreateDate(Timestamp createDate);
    List<Customer> findByFirstNameSubStr(String subStr);
    List<Customer> findAllCustomerIdDesc();
}
