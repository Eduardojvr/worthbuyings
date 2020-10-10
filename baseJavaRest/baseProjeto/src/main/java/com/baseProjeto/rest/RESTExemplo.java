package com.baseProjeto.rest;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/exemplo")
public class RESTExemplo {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@GET
	@Path("/getExemplo")
	@Produces({ MediaType.APPLICATION_JSON })
	public String get() {
		return "Base para projeto java!";
	}

}
