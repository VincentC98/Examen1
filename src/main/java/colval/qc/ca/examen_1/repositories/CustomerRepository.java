package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomerSortedByLastName();
    Customer findCustomerByCreateDate(Timestamp createDate);
    List<Customer> findByFirstNameSubStr(String subStr);
    List<Customer> findAllCustomerIdDesc();
    //requête demandé **Je n'ai pas réussi à utiliser celui avec les selects
    List<Customer> getSimilarFirstLastNameWithObject( String subStrFirst, String subStrLast);
    Optional<Customer> getCustomerDetailsByIdWithObject(@Param("customerId") Long customerId);
    List<Customer> getCustomerDetailsByDate(Date date);
}
