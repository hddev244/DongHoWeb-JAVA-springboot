package com.hddev244.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail  implements Serializable  {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private Double price;
      private Integer quantity;

      @JsonBackReference
      @ManyToOne
      @JoinColumn(name = "ProductId")
      private Product product;
      
      @JsonBackReference
      @ManyToOne
      @JoinColumn(name = "orderId",referencedColumnName = "id")
      private Order order;
}
