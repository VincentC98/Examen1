package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findStaffByFirstName(String firstName);
    Staff findStaffByFirstNameAndLastName(String firstName, String lastName);
}
