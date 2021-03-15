package colval.qc.ca.examen_1.services.interfaces;

import colval.qc.ca.examen_1.model.enitties.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    Staff create(Staff staff);

    Optional<Staff> readOne(Long staffId);

    List<Staff> readAll();

    void delete(Long staffId);

    List<Staff> getAllTenRandomStaff();

    List<Staff> getAllStaffByStoreId(long storeId);

}
