package edu.sgl.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.sgl.restaurant.domain.RestaurantMenu;

@Repository
public interface RestaurantMenuRepository extends
  JpaRepository<RestaurantMenu, Integer>, JpaSpecificationExecutor<RestaurantMenu> {

  List<RestaurantMenu> findByNameOrDescription(String menuName, String menuDesc);

}
