package com.hddev244.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	public static final Byte LOCKED = -1, NONE = 0, CUSTOMER = 1, ADMIN = 2;
	private String username;
	private String password;
	private Byte role = NONE;
}
