package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByPostalCode(String postalCode);
    Address findAddressByPhone(String phone);
}
