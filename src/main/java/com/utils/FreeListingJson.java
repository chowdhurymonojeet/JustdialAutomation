package com.utils;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class FreeListingJson {

	@SuppressWarnings("unchecked")
	public static void writeFreeListingjson(String output, String output1) {

		// Creating a JSONObject object
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(output, output1);
		try {
			FileWriter file = new FileWriter(System.getProperty("user.dir") + "\\OutputData\\FreeListingError.json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON file created: " + jsonObject);
	}
}
