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
@Table(name = "RESTAURANT_ORDERED")
public class RestaurantOrdered implements Serializable {

  private static final long serialVersionUID = 1425174829212466043L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String tableId;

  private LocalDateTime startTime;

  private LocalDateTime endTime;
}
