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
@Table(name = "RESTAURANT_RECEIPT")
public class RestaurantReceipt implements Serializable {

  private static final long serialVersionUID = -6350083836587742658L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderedId;

  private LocalDateTime exportedTime;

  private Double totalPrice;

  private Double vatPrice;

  private Double vatPercent;

}
