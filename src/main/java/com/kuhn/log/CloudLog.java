package com.kuhn.log;

import org.springframework.stereotype.Component;

@Component
public class CloudLog implements Log {

	@Override
	public void log(String message) {
		System.out.println("Cloud log: " + message);
	}

}
