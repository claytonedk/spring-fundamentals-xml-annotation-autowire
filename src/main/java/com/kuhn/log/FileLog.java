package com.kuhn.log;

import org.springframework.stereotype.Component;

@Component
public class FileLog implements Log {

	@Override
	public void log(String message) {
		System.out.println("File log: " + message);
	}

}
