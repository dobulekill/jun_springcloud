package net.chengp.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
	
	@Value("${server.port}")
	private int port;
	
	
	@RequestMapping("/providerResult")
	public String providerResult() {
		return "provider result, port="+port;
	}

}
