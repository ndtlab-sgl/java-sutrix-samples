package edu.sgl.restaurant.domain;

import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import edu.sgl.restaurant.domain.sql_builder.ISqlBuilder;

public class RestaurantMenuTest implements ISqlBuilder<RestaurantMenu> {

  @Test
  public void testGenerateSqlInsert() {
    final StringBuilder sqlBuilder = buildSqlBuilder(30);
    System.out.println(sqlBuilder.toString());
  }

  @Override
  public String prefixPattern() {
    return "INSERT INTO restaurant.RESTAURANT_MENU\n" +
        "(name, description, recipe, `type`, active)\n" +
        "VALUES\n";
  }

  @Override
  public String queryPattern() {
    return "('%s', '%s', '%s', '%s', %b),\n";
  }

  @Override
  public RestaurantMenu build() {
    RestaurantMenu menu = new RestaurantMenu();
    menu.setName(RandomStringUtils.randomAlphabetic(10));
    menu.setDescription(RandomStringUtils.randomAlphabetic(50));
    menu.setRecipe(RandomStringUtils.randomAlphabetic(100));
    menu.setType(RandomStringUtils.randomAlphanumeric(3));
    menu.setActive(RandomUtils.nextBoolean());
    return menu;
  }

  @Override
  public Function<RestaurantMenu, Object[]> fieldsMapping() {
    return item -> new Object[] { item.getName(), item.getDescription(),
        item.getRecipe(), item.getType(), item.isActive() };
  }

}
