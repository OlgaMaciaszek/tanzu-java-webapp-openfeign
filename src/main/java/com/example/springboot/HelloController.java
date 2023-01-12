package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final TestFeignClient feignClient;

	public HelloController(TestFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	@GetMapping("/")
	public String index() {
		return feignClient.index();
	}

	@GetMapping("/test")
	public String test() {
		return feignClient.test();
	}

}