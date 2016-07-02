package com.jr.farmacia.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Farmacia/rest
@ApplicationPath("rest")
public class FarmaciaResourceConfig extends ResourceConfig {
	public FarmaciaResourceConfig(){
		packages("com.jr.farmacia.service");
	}

}
