package com.hddev244.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand  implements Serializable {
      @Id
      private String id;
      private String name;

      @OneToMany(mappedBy = "brand")
      private List<Product> products;

      @Override
      public String toString() {
            return this.name;
      }
}
