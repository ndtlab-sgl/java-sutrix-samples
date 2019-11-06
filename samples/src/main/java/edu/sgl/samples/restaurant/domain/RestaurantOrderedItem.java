package edu.sgl.samples.restaurant.domain;

import java.time.LocalDateTime;

public class RestaurantOrderedItem {

  private String id;

  private String orderId;

  private String menuId;

  private int quantity;

  private double price;

  private LocalDateTime orderedTime;

  private boolean cancelled;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDateTime getOrderedTime() {
    return orderedTime;
  }

  public void setOrderedTime(LocalDateTime orderedTime) {
    this.orderedTime = orderedTime;
  }

  public boolean isCancelled() {
    return cancelled;
  }

  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }


}
