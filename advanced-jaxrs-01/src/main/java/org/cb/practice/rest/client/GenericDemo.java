package org.cb.practice.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.cb.practice.messenger.model.Message;

public class GenericDemo {
	
	public static void main(String args[])  {
		
		Client client = ClientBuilder.newClient();
		
		List<Message> list = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
							.path("messages")
							.queryParam("year", 2017)
							.request(MediaType.APPLICATION_JSON)
							.get(new GenericType<List<Message>>() { });
		System.out.println(list);
	}

}
