package colval.qc.ca.examen_1.services.impl;

import colval.qc.ca.examen_1.model.enitties.Store;
import colval.qc.ca.examen_1.services.interfaces.IStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements IStoreService {
    @Override
    public Store create(Store store) {
        return null;
    }

    @Override
    public Optional<Store> readOne(Long storeId) {
        return Optional.empty();
    }

    @Override
    public List<Store> readAll() {
        return null;
    }

    @Override
    public void delete(Long storeId) {

    }
}
