package com.hddev244.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReportRevenue implements Serializable {
  @Id
  @Column(name = "group_by")
  private Serializable group;
  private Double revenues;
  private Long counts;
}
