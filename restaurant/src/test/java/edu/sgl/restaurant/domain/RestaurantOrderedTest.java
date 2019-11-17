package edu.sgl.restaurant.domain;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import edu.sgl.restaurant.domain.sql_builder.ISqlBuilder;

public class RestaurantOrderedTest implements ISqlBuilder<RestaurantOrdered> {

  @Test
  public void testGenerateSqlInsert() {
    final StringBuilder sqlBuilder = buildSqlBuilder(1000);
    System.out.println(sqlBuilder.toString());
  }

  @Override
  public String prefixPattern() {
    return "INSERT INTO restaurant.RESTAURANT_ORDERED\n" +
        "(endTime, startTime, tableId)\n" +
        "VALUES\n" +
        "";
  }

  @Override
  public String queryPattern() {
    return "('%s', '%s', '%s'),\n";
  }

  @Override
  public RestaurantOrdered build() {
    RestaurantOrdered ordered = new RestaurantOrdered();
    ordered.setTableId(String.valueOf(RandomUtils.nextInt(1, 1000)));
    ordered.setStartTime(LocalDateTime.now());
    ordered.setEndTime(ordered.getStartTime().plusHours(2));
    return ordered;
  }

  @Override
  public Function<RestaurantOrdered, Object[]> fieldsMapping() {
    return item -> new Object[] { item.getEndTime().toString(),
        item.getStartTime().toString(),
        item.getTableId() };
  }

}
