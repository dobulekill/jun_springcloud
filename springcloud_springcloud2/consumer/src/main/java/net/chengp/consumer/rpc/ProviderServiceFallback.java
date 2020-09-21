package net.chengp.consumer.rpc;

import org.springframework.stereotype.Component;

@Component
public class ProviderServiceFallback implements ProviderService{

	@Override
	public String providerReuslt() {
		return "ProviderServiceFallback invoker~!";
	}

}
