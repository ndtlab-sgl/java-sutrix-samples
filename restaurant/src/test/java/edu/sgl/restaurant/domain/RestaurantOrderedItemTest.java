package edu.sgl.restaurant.domain;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import edu.sgl.restaurant.domain.sql_builder.ISqlBuilder;

public class RestaurantOrderedItemTest implements ISqlBuilder<RestaurantOrderedItem> {

  @Test
  public void testGenerateSqlInsert() {
    final StringBuilder sqlBuilder = buildSqlBuilder(3000);
    System.out.println(sqlBuilder.toString());
  }

  @Override
  public String prefixPattern() {
    return "INSERT INTO restaurant.RESTAURANT_ORDERED_ITEM\n" +
        "(cancelled, menuId, orderId, orderedTime, price, quantity)\n" +
        "VALUES\n";
  }

  @Override
  public String queryPattern() {
    return "(%b, '%s', %d, '%s', %f, %d),\n";
  }

  @Override
  public RestaurantOrderedItem build() {
    RestaurantOrderedItem item = new RestaurantOrderedItem();
    item.setMenuId(String.valueOf(RandomUtils.nextInt(1, 30)));
    item.setOrderedTime(LocalDateTime.now());
    item.setOrderId(RandomUtils.nextLong(1, 1000));
    item.setPrice(RandomUtils.nextDouble(1d, 100d));
    item.setQuantity(RandomUtils.nextInt(1, 10));
    item.setCancelled(RandomUtils.nextBoolean());
    return item;
  }

  @Override
  public Function<RestaurantOrderedItem, Object[]> fieldsMapping() {
    return item -> new Object[] {
        item.isCancelled(),
        item.getMenuId(),
        item.getOrderId(),
        item.getOrderedTime().toString(),
        item.getPrice(),
        item.getQuantity()
    };
  }

}
