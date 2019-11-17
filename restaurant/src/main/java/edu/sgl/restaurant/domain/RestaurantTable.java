package edu.sgl.restaurant.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable implements Serializable {

  private static final long serialVersionUID = -2827184807264956072L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private int numberOfSeats;

  private String position;

  private String positionDescription;
}
