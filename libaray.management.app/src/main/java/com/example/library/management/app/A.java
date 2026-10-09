package com.example.library.management.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class A {
	@GetMapping
	public String a()
	{
		return "Welcome";
	}
}
