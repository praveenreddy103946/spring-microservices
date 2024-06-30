package com.fiegn.FiegnClient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//http://localhost:6060/address-app/run/1947

//No Feign Client for loadBalancing defined. Did you forget to include spring-cloud-starter-loadbalancer?


//@FeignClient(name="Address-Application",url="http://localhost:6060",path = "address-app/run/")

@FeignClient(name="Address-Application",path = "address-app/run/")
@RibbonClient(name="Address-Application")  //Dynamic Load Balancer
public interface AddressClient {
	
	@GetMapping("{input}")
	String getAddressFromEmployee(@PathVariable("input") String  input);
	
	/*
	 * 
	 * imagine if you have a new API method introduced inside your address Controller  
	 * you can add  them here
	 *   
	 */

}
