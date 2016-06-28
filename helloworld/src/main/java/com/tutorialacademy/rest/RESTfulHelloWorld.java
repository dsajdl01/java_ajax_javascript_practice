package com.tutorialacademy.rest;
/* * *
 * 
 * https://examples.javacodegeeks.com/enterprise-java/rest/jersey/json-example-with-jersey-jackson/
 * 
 * * */

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/rest")
public class RESTfulHelloWorld {

	@GET
	@Path("getHelloWord")
	@Produces("text/html")
	public Response getStartingPage()
	{ 
		String output = "Hello World from rest layer!," +
				"RESTful Service is running ..., Ping @ " + new Date().toString();
		return Response.status(200).entity(output).build();
	}
}
