package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findStaffByFirstName(String firstName);
    Staff findStaffByFirstNameAndLastName(String firstName, String lastName);
    //requête demandé
    List<Staff> getStaffByStore(long storeId);
}
