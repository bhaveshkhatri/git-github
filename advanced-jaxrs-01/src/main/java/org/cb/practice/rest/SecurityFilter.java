package org.cb.practice.rest;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "secured";
																						
	
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		System.out.println("outside filter");
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		System.out.println("secured filter");
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		
		if(authHeader!=null && authHeader.size()>0) {
			
			String authToken = authHeader.get(0);			
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");			
			String decodeString = Base64.decodeAsString(authToken);
			
			StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
			
			String userName = tokenizer.nextToken();
			System.out.println("secured filter2");
			System.out.println(userName);
			String password = tokenizer.nextToken();
			System.out.println("secured filter2");
			
			if("username".equals(userName) && "password".equals(password)) {
			 
				return;
			}
		}
		
		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
												.entity("User can not access the resource")
												.build();
		
		requestContext.abortWith(unauthorizedStatus);
		
		
	}
	}
	
}
