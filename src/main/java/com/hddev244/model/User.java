package com.hddev244.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	protected Account account;
	protected String fullname;
	protected String email;
	protected String phoneNumber;
	protected String address;
}
