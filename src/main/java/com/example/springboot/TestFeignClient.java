package com.example.springboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Olga Maciaszek-Sharma
 */
@FeignClient(value = "tanzu-java-web-app")
interface TestFeignClient {

	@GetMapping("/")
	String index();

	@GetMapping("/test")
	String test();
}
