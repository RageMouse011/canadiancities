package com.acrhipelago.canadiancities.repository;

import com.acrhipelago.canadiancities.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityGraphQLRepository extends CrudRepository<City, Integer> {
}
