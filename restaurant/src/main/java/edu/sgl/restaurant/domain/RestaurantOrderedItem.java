package edu.sgl.restaurant.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "RESTAURANT_ORDERED_ITEM")
public class RestaurantOrderedItem implements Serializable {

  private static final long serialVersionUID = 2935053251962053571L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long orderId;

  private String menuId;

  private int quantity;

  private double price;

  private LocalDateTime orderedTime;

  private boolean cancelled;
}
