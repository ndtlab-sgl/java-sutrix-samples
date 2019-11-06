package edu.sgl.samples.restaurant.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.sgl.samples.restaurant.domain.RestaurantMenu;
import edu.sgl.samples.restaurant.domain.RestaurantOrdered;
import edu.sgl.samples.restaurant.domain.RestaurantOrderedItem;
import edu.sgl.samples.restaurant.repository.RestaurantMenuRepository;

public class MostOfOrderedMealsByHourlyRestaurantStats
    extends AbstractRestaurantStats<List<RestaurantOrdered>, Map<RestaurantShift, RestaurantMenu>> {

  private RestaurantMenuRepository menuRepo;

  @Override
  public Map<RestaurantShift, RestaurantMenu> stats(List<RestaurantOrdered> orders) {

    List<RestaurantOrderedItem> orderedItems = new ArrayList<>();
    for (RestaurantOrdered order : orders) {
      orderedItems.addAll(order.getItems());
    }

    Map<RestaurantShift, RestaurantMenu> result = new HashMap<>();

    Map<RestaurantShift, List<RestaurantOrderedItem>> ordersByShift =
        new HashMap<>();
    for (RestaurantOrderedItem item : orderedItems) {
      RestaurantShift shift =
          RestaurantShift.getShift(item.getOrderedTime());

      if (!ordersByShift.containsKey(shift)) {
        ordersByShift.put(shift, new ArrayList<>());
      }

      ordersByShift.get(shift).add(item);
    }

    for (
        Entry<RestaurantShift, List<RestaurantOrderedItem>> entry :
          ordersByShift.entrySet()) {

      RestaurantShift shift = entry.getKey();
      List<RestaurantOrderedItem> items = entry.getValue();

      Map<String, Integer> countMap = new HashMap<>();
      for (RestaurantOrderedItem item : items) {
        if (!countMap.containsKey(item.getMenuId())) {
          countMap.put(item.getMenuId(), 0);
        }
        countMap.put(item.getId(),
            countMap.get(item.getId()) + item.getQuantity());
      }

      // Sorting to get max value
      String menuId = "";

      // Find Restaurant Menu by menuid;
      RestaurantMenu rs = menuRepo.findById(menuId);
      result.put(shift, rs);
    }

    return result;
  }

}
