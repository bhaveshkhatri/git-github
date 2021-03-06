package org.cb.practice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.cb.practice.messenger.model.Message;
import org.cb.practice.messenger.resources.beans.MessageFilterBean;
import org.cb.practice.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getAllMessage(@BeanParam MessageFilterBean msgFilterBean) {
		
		if(msgFilterBean.getYear() > 0) {
			return messageService.getMessagesForYear(msgFilterBean.getYear());
		}
		if(msgFilterBean.getStart() >= 0 && msgFilterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(msgFilterBean.getStart(), msgFilterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
		
	/*@POST														//	
	public Message addMessage(Message message) {				//
																//Same is implemented below in another way
		return messageService.addMessage(message);				//
	} */													//
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
		
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	}
	

	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long id) throws Throwable {
		
		return messageService.removeMessage(id);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		
		return new CommentResource();
	}

}