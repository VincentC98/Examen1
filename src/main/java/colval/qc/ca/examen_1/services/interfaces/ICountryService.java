package colval.qc.ca.examen_1.services.interfaces;

import colval.qc.ca.examen_1.model.enitties.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    Country create(Country country);

    Optional<Country> readOne(Long countryId);

    List<Country> readAll();

    void delete(Long countryId);

    Long countAllCountry();

}
