package org.cb.practice.rest;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.model.ParamQualifier;

@Path("test")
public class MyResource {
	
	
	
	@GET 
	
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		
		return "This is test method!";
		
		//return "pathParam: "+pathParam+"  "+"queryParam: "+query;
	}

}
