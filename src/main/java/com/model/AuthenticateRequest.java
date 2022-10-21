package com.model;

import lombok.Data;

@Data
public class AuthenticateRequest {
	private Employee user;
	private Request request;
}
