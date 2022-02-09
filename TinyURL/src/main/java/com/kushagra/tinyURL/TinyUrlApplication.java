package com.kushagra.tinyURL;

import com.kushagra.tinyURL.service.TinyUrlService;

public class TinyUrlApplication {

	public static void main(String[] args) {
		TinyUrlService tinyUrlService = new TinyUrlService();
		tinyUrlService.process();
	}

}
