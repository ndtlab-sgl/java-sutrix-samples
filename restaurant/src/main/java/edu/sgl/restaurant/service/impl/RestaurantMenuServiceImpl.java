package edu.sgl.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.sgl.restaurant.domain.RestaurantMenu;
import edu.sgl.restaurant.form.MenuSearchForm;
import edu.sgl.restaurant.repository.RestaurantMenuRepository;
import edu.sgl.restaurant.service.RestaurantMenuService;
import edu.sgl.restaurant.spec.MenuSpec;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestaurantMenuServiceImpl implements RestaurantMenuService {

  @Autowired
  private RestaurantMenuRepository resMenuRepo;

  @Override
  public List<RestaurantMenu> searchMenuList(MenuSearchForm form, Pageable pageable) {
    log.debug("Search form = {} - pageable = {}", form, pageable);

    MenuSpec spec = new MenuSpec();
    spec.setForm(form);
    return resMenuRepo.findAll(spec);
  }

}
