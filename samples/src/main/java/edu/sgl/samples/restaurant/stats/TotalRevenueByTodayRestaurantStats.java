package edu.sgl.samples.restaurant.stats;

import java.util.List;

import edu.sgl.samples.restaurant.domain.RestaurantReceipt;

public class TotalRevenueByTodayRestaurantStats
    extends AbstractRestaurantStats<List<RestaurantReceipt>, Double> {

  @Override
  public Double stats(List<RestaurantReceipt> criteria) {

    return 0d;
  }

}
