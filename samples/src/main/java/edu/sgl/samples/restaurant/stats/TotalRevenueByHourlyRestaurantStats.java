package edu.sgl.samples.restaurant.stats;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import edu.sgl.samples.restaurant.domain.RestaurantReceipt;

public class TotalRevenueByHourlyRestaurantStats
  extends AbstractRestaurantStats<List<RestaurantReceipt>, Map<LocalDateTime, Double>> {

  @Override
  public Map<LocalDateTime, Double> stats(List<RestaurantReceipt> criteria) {

    return Collections.emptyMap();
  }

}
