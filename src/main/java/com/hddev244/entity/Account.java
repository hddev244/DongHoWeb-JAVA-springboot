package com.hddev244.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Accounts")
public class Account implements Serializable {
      @Id
      @Nonnull
      private String username;
      @Nonnull
      private String password;
      private String fullname;
      private String email;
      private String photo;
      private String address;
      private String phoneNumber;
      private boolean activated = true;
      private boolean admin = false;


      @JsonManagedReference
      @OneToMany(mappedBy = "account")
      private List<Order> orders;

      @JsonManagedReference
      @OneToMany(mappedBy = "account")
      private List<CartItem> cartItems;
}