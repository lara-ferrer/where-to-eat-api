package com.laraferrer.wheretoeat.repository;

import com.laraferrer.wheretoeat.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
