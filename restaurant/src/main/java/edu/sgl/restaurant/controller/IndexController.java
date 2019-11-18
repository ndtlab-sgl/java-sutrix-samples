package edu.sgl.restaurant.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sgl.restaurant.form.MenuSearchForm;
import edu.sgl.restaurant.repository.RestaurantMenuRepository;
import edu.sgl.restaurant.service.RestaurantMenuService;

@Controller
public class IndexController {

  @Autowired
  private RestaurantMenuRepository resMenuRepo;

  @Autowired
  private RestaurantMenuService menuService;

  @RequestMapping
  public String index(Model model) {
    System.out.println("Into index page");
    model.addAttribute("welcomeName", RandomStringUtils.random(10));
    return "/index";
  }

  @RequestMapping(value = "/menu")
  public String menuPage(Model model) {
    model.addAttribute("searchForm", new MenuSearchForm());
    model.addAttribute("menuList", resMenuRepo.findAll());
    return "/menu";
  }

  @RequestMapping(value = "/menu/search",
      method = RequestMethod.POST)
  public String searchMenu(Model model,
      @ModelAttribute MenuSearchForm searchForm) {
    System.out.println(searchForm.getName());
    model.addAttribute("searchForm", searchForm);
    model.addAttribute("menuList", menuService.searchMenuList(searchForm, Pageable.unpaged()));
    return "/menu";
  }

}
