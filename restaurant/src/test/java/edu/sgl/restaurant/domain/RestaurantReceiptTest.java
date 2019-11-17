package edu.sgl.restaurant.domain;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import edu.sgl.restaurant.domain.sql_builder.ISqlBuilder;

public class RestaurantReceiptTest implements ISqlBuilder<RestaurantReceipt> {

  @Test
  public void testGenerateSqlInsert() {
    final StringBuilder sqlBuilder = buildSqlBuilder(2000);
    System.out.println(sqlBuilder.toString());
  }

  @Override
  public String prefixPattern() {
    return "INSERT INTO restaurant.RESTAURANT_RECEIPT\n" +
        "(exportedTime, orderedId, totalPrice, vatPercent, vatPrice)\n" +
        "VALUES\n";
  }

  @Override
  public String queryPattern() {
    return "('%s', '%s', %f, %f, %f),\n";
  }

  @Override
  public RestaurantReceipt build() {
    RestaurantReceipt receipt = new RestaurantReceipt();
    receipt.setExportedTime(LocalDateTime.now());
    receipt.setOrderedId(String.valueOf(RandomUtils.nextInt(1, 1000)));
    receipt.setTotalPrice(RandomUtils.nextDouble(10d, 1000d));
    receipt.setVatPercent(RandomUtils.nextDouble(0d, 10d));
    receipt.setVatPrice(null);
    return receipt;
  }

  @Override
  public Function<RestaurantReceipt, Object[]> fieldsMapping() {
    return item -> new Object[] {
        item.getExportedTime().toString(),
        item.getOrderedId(),
        item.getTotalPrice(),
        item.getVatPercent(),
        item.getVatPrice()
    };
  }

}
