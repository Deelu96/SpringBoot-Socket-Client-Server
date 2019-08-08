package org.springframework.integration.samples.tcpclientserver;

public class EchoService {

	public String test(String input) {
		if ("FAIL".equalsIgnoreCase(input)) {
			throw new RuntimeException("Failure Demonstration");
		}
		return "echo:" + input;
	}

}
