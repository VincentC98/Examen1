package colval.qc.ca.examen_1.services.impl;

import colval.qc.ca.examen_1.model.enitties.City;
import colval.qc.ca.examen_1.repositories.CityRepository;
import colval.qc.ca.examen_1.services.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return null;
    }

    @Override
    public Optional<City> readOne(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> readAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public Long countAllCity() {
        return cityRepository.count();
    }

    @Override
    public List<City> getAllTenRandomCity() {
        List<City> cities = cityRepository.findAll();
        Collections.shuffle(cities);
        return cities.stream().limit(10).collect(Collectors.toList());

    }
}
