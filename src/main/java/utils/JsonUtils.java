package utils;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.LoginData;

public class JsonUtils {

	private JsonUtils() {
	}

	public static LoginData[] getLoginData(String filePath) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			return mapper.readValue(new File(filePath), LoginData[].class);

		}

		catch (Exception e) {

			throw new RuntimeException(e);

		}
	}
}