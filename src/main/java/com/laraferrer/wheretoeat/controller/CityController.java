package com.laraferrer.wheretoeat.controller;

import com.laraferrer.wheretoeat.domain.City;
import com.laraferrer.wheretoeat.dto.CityDTO;
import com.laraferrer.wheretoeat.dto.ErrorResponse;
import com.laraferrer.wheretoeat.dto.PatchDTO;
import com.laraferrer.wheretoeat.service.CityService;
import com.laraferrer.wheretoeat.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city")
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = null;
        cities = cityService.findAllCities();

        return ResponseEntity.ok(cities);
    }

    @GetMapping(value = "/city/{cityId}")
    public ResponseEntity<CityDTO> getNameById(@PathVariable long cityId) throws CityNotFoundException {
        CityDTO cityDTO = cityService.findNameById(cityId);

        return ResponseEntity.ok(cityDTO);
    }

    @PostMapping(value = "/city")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City newCity = cityService.addCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/city/{cityId}")
    public ResponseEntity<City> modifyCity(@PathVariable long cityId, @RequestBody City city) throws CityNotFoundException {
        City newCity = cityService.modifyCity(cityId, city);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }

    @PatchMapping(value = "/city/{cityId}")
    public ResponseEntity<Void> patchCity(@PathVariable long cityId, @RequestBody PatchDTO patchDTO) throws CityNotFoundException {
        cityService.patchCity(cityId, patchDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/city/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable long cityId) throws CityNotFoundException {
        cityService.deleteCityById(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(CityNotFoundException cityNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(101, cityNotFoundException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(102, "Error interno del servidor.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}