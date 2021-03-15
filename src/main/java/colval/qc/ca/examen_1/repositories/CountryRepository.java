package colval.qc.ca.examen_1.repositories;

import colval.qc.ca.examen_1.model.enitties.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByCountry(String country);

}
