package edu.sgl.samples.restaurant.domain;

import java.time.LocalDateTime;

public class RestaurantReceipt {

  private String id;

  private String orderedId;

  private LocalDateTime exportedTime;

  private Double totalPrice;

  private Double vatPrice;

  private Double vatPercent;
}
