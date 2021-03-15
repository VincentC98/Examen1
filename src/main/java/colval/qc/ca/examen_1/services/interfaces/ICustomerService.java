package colval.qc.ca.examen_1.services.interfaces;

import colval.qc.ca.examen_1.model.enitties.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer create(Customer customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    Customer updateFirstNameAndLastName(Long customerId,String firstName,String lastName);

    Long countAllCustomer();

    List<Customer> findAllCustomerIdDescAndLimit50();

    List<Customer> getAllCustomerWithFirstNameSubStr(String subStr);

    List<Customer> getAllCustomerWithFirstNameAndLastNameSubStr(String subStrFirst, String subStrLast);

    Optional<Customer> getCustomerDetailById(long id);

}
