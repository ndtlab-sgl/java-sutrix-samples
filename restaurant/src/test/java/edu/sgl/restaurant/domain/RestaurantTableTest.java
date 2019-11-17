package edu.sgl.restaurant.domain;

import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import edu.sgl.restaurant.domain.sql_builder.ISqlBuilder;

public class RestaurantTableTest implements ISqlBuilder<RestaurantTable> {

  @Test
  public void testGenerateSqlInsert() {
    final StringBuilder sqlBuilder = buildSqlBuilder(1000);
    System.out.println(sqlBuilder.toString());
  }

  @Override
  public String prefixPattern() {
    return "INSERT INTO restaurant.RESTAURANT_TABLE\n" +
        "(name, numberOfSeats, `position`, positionDescription)\n" +
        "VALUES\n";
  }

  @Override
  public String queryPattern() {
    return "('%s', %d, '%s', '%s'),\n";
  }

  @Override
  public RestaurantTable build() {
    RestaurantTable table = new RestaurantTable();
    table.setName(RandomStringUtils.randomAlphabetic(10));
    table.setNumberOfSeats(RandomUtils.nextInt(1, 12));
    table.setPosition(StringUtils.EMPTY);
    table.setPositionDescription(StringUtils.EMPTY);
    return table;
  }

  @Override
  public Function<RestaurantTable, Object[]> fieldsMapping() {
    return item -> new Object[] { item.getName(), item.getNumberOfSeats(),
        item.getPosition(), item.getPositionDescription() };
  }



}
