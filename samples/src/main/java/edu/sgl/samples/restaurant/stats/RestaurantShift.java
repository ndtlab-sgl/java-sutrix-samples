package edu.sgl.samples.restaurant.stats;

import java.time.LocalDateTime;

public enum RestaurantShift {

  MORNING,
  AFTERNOON,
  NIGHT;

  static RestaurantShift getShift(LocalDateTime time) {
    if (time.getHour() >= 7 && time.getHour() <= 10) {
      return MORNING;
    } else if (time.getHour() >= 10 && time.getHour() <= 15) {
      return AFTERNOON;
    }
    return NIGHT;
  }
}
