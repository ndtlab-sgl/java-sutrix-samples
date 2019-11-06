package edu.sgl.samples.restaurant;

import java.util.Collections;
import java.util.Map;

import edu.sgl.samples.restaurant.domain.RestaurantMenu;
import edu.sgl.samples.restaurant.repository.RestaurantMenuRepository;
import edu.sgl.samples.restaurant.stats.MostOfOrderedMealsByHourlyRestaurantStats;
import edu.sgl.samples.restaurant.stats.RestaurantShift;
import edu.sgl.samples.restaurant.stats.TotalRevenueByHourlyRestaurantStats;
import edu.sgl.samples.restaurant.stats.TotalRevenueByTodayRestaurantStats;

public class RestaurantManagementApplication {

  public static void main(String...strings) {
    System.out.println("##### Running Restaurant Management Application! #####");

    RestaurantMenuRepository menuRepository = new RestaurantMenuRepository();
    menuRepository.findAllByDummy();

    System.out.println("### Excersise 1: Most of ordered meals by hourly ###");

    MostOfOrderedMealsByHourlyRestaurantStats stats1 =
        new MostOfOrderedMealsByHourlyRestaurantStats();
    Map<RestaurantShift, RestaurantMenu> result1 = stats1.stats(Collections.emptyList());
    result1.forEach((shift, menu) -> System.out.println(
        String.format("Top %d - date %s - meal %s", shift, menu)));

    System.out.println("### End Excersise 1: Most of ordered meals by hourly ###");

    System.out.println("### Excersise 2:  ###");
    TotalRevenueByTodayRestaurantStats stats2 = new TotalRevenueByTodayRestaurantStats();

    System.out.println("### End Excersise 2:  ###");

    System.out.println("### Excersise 3:  ###");
    TotalRevenueByHourlyRestaurantStats stats3 = new TotalRevenueByHourlyRestaurantStats();
    System.out.println("### End Excersise 3:  ###");

    System.out.println("##### End Running Restaurant Management Application! #####");
  }

}
