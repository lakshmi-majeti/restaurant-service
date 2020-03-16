package com.peak.restaurant.repository;

import com.peak.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findByCuisineIgnoreCase(@Param("cuisine") String cuisine);
}
