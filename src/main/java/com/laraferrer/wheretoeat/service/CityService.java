package com.laraferrer.wheretoeat.service;

import com.laraferrer.wheretoeat.domain.City;
import com.laraferrer.wheretoeat.dto.CityDTO;
import com.laraferrer.wheretoeat.dto.UserDTO;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import com.laraferrer.wheretoeat.exception.UserNotFoundException;

import java.util.List;

public interface CityService {
    List<City> findAllCities();
    CityDTO findNameById(long cityId) throws CityNotFoundException;
    City addCity(City city);
    City modifyCity(long cityId, City city) throws CityNotFoundException;
    void patchCity(long cityId, PatchDTO patchDTO) throws CityNotFoundException;
    void deleteCityById(long cityId) throws CityNotFoundException;
}
