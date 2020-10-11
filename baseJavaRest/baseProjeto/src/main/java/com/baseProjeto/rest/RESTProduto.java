package com.baseProjeto.rest;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.baseProjeto.dao.ProdutoDAO;
import com.baseProjeto.entity.Produto;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/produto")
public class RESTProduto {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@GET
	@Path("/getAllProducts")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllProducts() {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> todos = null;
		try {
			todos = dao.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return Response.status(Status.OK).entity(todos).build();
	}

}
