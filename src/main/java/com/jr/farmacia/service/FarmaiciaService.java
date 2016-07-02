package com.jr.farmacia.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http://localhost:8080/Farmacia/rest/farmacia

@Path("farmacia")
public class FarmaiciaService {
	@GET
	public String exibir(){
		return "Java Web";
	}

}
