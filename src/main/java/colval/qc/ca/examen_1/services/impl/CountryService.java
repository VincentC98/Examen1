package colval.qc.ca.examen_1.services.impl;

import colval.qc.ca.examen_1.model.enitties.Country;
import colval.qc.ca.examen_1.repositories.CountryRepository;
import colval.qc.ca.examen_1.services.interfaces.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return null;
    }

    @Override
    public Optional<Country> readOne(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public List<Country> readAll() {
        return countryRepository.findAll();
    }

    @Override
    public void delete(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public Long countAllCountry() {
        return countryRepository.count();
    }
}
