package edu.sgl.samples.restaurant.domain;

import java.time.LocalDateTime;
import java.util.List;

public class RestaurantOrdered {

  private String id;

  private String tableId;

  private List<RestaurantOrderedItem> items;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTableId() {
    return tableId;
  }

  public void setTableId(String tableId) {
    this.tableId = tableId;
  }

  public List<RestaurantOrderedItem> getItems() {
    return items;
  }

  public void setItems(List<RestaurantOrderedItem> items) {
    this.items = items;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }


}
