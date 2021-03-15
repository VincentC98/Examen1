package colval.qc.ca.examen_1.services.impl;

import colval.qc.ca.examen_1.model.enitties.Customer;
import colval.qc.ca.examen_1.repositories.CustomerRepository;
import colval.qc.ca.examen_1.services.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllCustomerSortedByLastName();
    }

    @Override
    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
    }

    @Override
    public Long countAllCustomer() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAllCustomerIdDescAndLimit50() {
        return customerRepository.findAllCustomerIdDesc().stream().limit(50).collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllCustomerWithFirstNameSubStr(String subStr) {
        return customerRepository.findByFirstNameSubStr(subStr);
    }

    @Override
    public List<Customer> getAllCustomerWithFirstNameAndLastNameSubStr(String subStrFirst, String subStrLast) {
        return  customerRepository.getSimilarFirstLastName(subStrFirst, subStrLast);
    }

    @Override
    public Optional<Customer> getCustomerDetailById(long id) {
        return customerRepository.getCustomerDetailsById(id);
    }


}
