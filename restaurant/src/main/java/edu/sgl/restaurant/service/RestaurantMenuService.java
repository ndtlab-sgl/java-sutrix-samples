package edu.sgl.restaurant.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import edu.sgl.restaurant.domain.RestaurantMenu;
import edu.sgl.restaurant.form.MenuSearchForm;

public interface RestaurantMenuService {

  List<RestaurantMenu> searchMenuList(MenuSearchForm form, Pageable pageable);

}
