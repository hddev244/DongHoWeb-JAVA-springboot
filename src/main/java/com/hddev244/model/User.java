package com.hddev244.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	protected String username;
	protected String fullname;
	protected String password;
	protected String email;
	protected String phoneNumber;
	protected String address;
}
