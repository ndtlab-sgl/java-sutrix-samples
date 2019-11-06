package edu.sgl.samples.restaurant.repository;

import java.util.Collections;
import java.util.List;

import edu.sgl.samples.restaurant.domain.RestaurantMenu;

public class RestaurantMenuRepository {

  public List<RestaurantMenu> findAllByDummy() {
    return Collections.emptyList();
  }

  public RestaurantMenu findById(String menuId) {
    return new RestaurantMenu();
  }

}
