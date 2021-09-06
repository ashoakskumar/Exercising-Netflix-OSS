package com.ashok.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

public class RibbonConfiguration {
	
	@Autowired
	private IClientConfig ribbonClientConfig;
	
	@Bean
	public IPing ribbonPing(IClientConfig config)
	{
		return new PingUrl();
	}
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		//return new WeightedResponseTimeRule();
		return new AvailabilityFilteringRule();
	}
	
	 @Bean
	    public ServerList<Server> ribbonServerList(IClientConfig config) {
	        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
	        serverList.initWithNiwsConfig(config);

	        return serverList;
	    }
}
