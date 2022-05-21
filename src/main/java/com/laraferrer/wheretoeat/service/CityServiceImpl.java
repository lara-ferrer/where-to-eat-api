package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.City;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.repository.CityRepository;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City modifyCity(long cityId, City city) throws CityNotFoundException {
        City newCity = cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
        newCity.setId(city.getId());
        newCity.setName(city.getName());

        return cityRepository.save(newCity);
    }

    @Override
    public void patchCity(long cityId, PatchDTO patchDTO) throws CityNotFoundException {
        City newCity = cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
        if (patchDTO.getKey().equals("name")) {
            newCity.setName(patchDTO.getValue());
        }
        if (patchDTO.getKey().equals("country")) {
            newCity.setCountry(patchDTO.getValue());
        }

        cityRepository.save(newCity);
    }

    @Override
    public void deleteCityById(long cityId) throws CityNotFoundException {
        City city = cityRepository.findById(cityId)
                .orElseThrow(CityNotFoundException::new);
        cityRepository.delete(city);
    }
}
