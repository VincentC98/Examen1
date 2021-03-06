package colval.qc.ca.examen_1.services.interfaces;

import colval.qc.ca.examen_1.model.enitties.Store;

import java.util.List;
import java.util.Optional;

public interface IStoreService {
    Store create(Store store);

    Optional<Store> readOne(Long storeId);

    List<Store> readAll();

    void delete(Long storeId);
}
