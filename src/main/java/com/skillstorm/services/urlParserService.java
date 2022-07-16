package com.skillstorm.services;

public class urlParserService {

	public int extractId(String url) {
		
	
		String[] splitString = url.split("/");
		
	
		return Integer.parseInt(splitString[1]);
	}
	
	
}
