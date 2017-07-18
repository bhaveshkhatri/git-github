package org.cb.practice.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cb.practice.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-01/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
// Making @GET request
		Message message1 = singleMessageTarget
											.resolveTemplate("messageId", "1")
											.request(MediaType.APPLICATION_JSON)
											.get(Message.class);
		
		Message message2 = singleMessageTarget
											.resolveTemplate("messageId", "4")
											.request(MediaType.APPLICATION_JSON)
											.get(Message.class);
		
		//System.out.println(message1.getMessage());
		//System.out.println(message2.getMessage());
		
// Making @POST request
		Message newMessage = new Message(7L, "Hai mummy", "chinna");
		Response response = messagesTarget
										.request()
										.post(Entity.json(newMessage));
		
		if(response.getStatus()!=201) {
			System.out.println("Error");
		}
		
		Message createdMessage = response.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());
											
				
		
		
		/*String response = client
							.target("http://localhost:8080/advanced-jaxrs-01/webapi/messages/1")
							.request(MediaType.APPLICATION_JSON)
							.get(String.class);

		//Message message = response.readEntity(Message.class);
		System.out.println(response);
		//System.out.println(message.getMessage());
*/
	}

}
