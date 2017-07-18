package org.cb.practice.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cb.practice.messenger.model.Message;
import org.cb.practice.service.MessageService;

public class InvocationDemo {

	public static void main(String[] args) {

		InvocationDemo demo = new InvocationDemo();
	
		Invocation invocation = demo.prepareRequestForMessageByYear(2017);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
		List<Message> list = response.readEntity(List.class);
		for(int i=0;i<list.size();i++)
		System.out.println(list.get(i));
	}

	public Invocation prepareRequestForMessageByYear(int year) {
		
		Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/advanced-jaxrs-01/webapi/")
				.path("messages")
				.queryParam("year", year)
				.request(MediaType.APPLICATION_JSON)
				.buildGet();
		
	}

}
