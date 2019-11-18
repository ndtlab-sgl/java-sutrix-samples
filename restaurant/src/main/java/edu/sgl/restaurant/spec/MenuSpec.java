package edu.sgl.restaurant.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import edu.sgl.restaurant.domain.RestaurantMenu;
import edu.sgl.restaurant.form.MenuSearchForm;
import lombok.Data;

@Data
public class MenuSpec implements Specification<RestaurantMenu> {

  private static final long serialVersionUID = 4515265050091979354L;
  private MenuSearchForm form;

  @Override
  public Predicate toPredicate(Root<RestaurantMenu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

    return criteriaBuilder.and(criteriaBuilder.like(
        root.get("name"), "%" + form.getName() + "%"))
        ;
  }

}
