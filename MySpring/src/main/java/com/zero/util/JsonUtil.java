package com.zero.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
	}

	public static <T> T readValue(File file, Class<T> clazz) {
		T object = null;
		try {
			object = objectMapper.readValue(file, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}
