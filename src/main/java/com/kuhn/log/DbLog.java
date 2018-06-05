package com.kuhn.log;

import org.springframework.stereotype.Component;

@Component
public class DbLog implements Log {

	@Override
	public void log(String message) {
		System.out.println("Database log: " + message);
	}

}
