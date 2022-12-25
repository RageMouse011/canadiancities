package com.acrhipelago.canadiancities.repository;

import com.acrhipelago.canadiancities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRestRepository extends JpaRepository<City, Integer> {
}
