package org.cb.practice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.cb.practice.messenger.database.DatabaseClass;
import org.cb.practice.messenger.exception.DataNotFoundException;
import org.cb.practice.messenger.model.Message;

public class MessageService {
			
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
public MessageService() {
		
	messages.put(1L, new Message(1L, "Hello world!", "chinna"));
	messages.put(2L, new Message(2L, "Hello there!", "world"));
	messages.put(3L, new Message(3L, "How are you!", "ram"));
	messages.put(4L, new Message(4L, "I am fine!", "cb"));
	messages.put(5L, new Message(5L, "I am runninng!", "padma"));
	messages.put(6L, new Message(6L, "eating!", "world"));
	}
	
	// To get all the messages.....
	public List<Message> getAllMessages() {
		
		return new ArrayList<Message>(messages.values());
	}
	
	
	public List<Message> getMessagesForYear(int year) {
		
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
				
		return messagesForYear;
	}
	
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		
		List<Message> list = new ArrayList<Message>(messages.values());
		
		if(start+size > list.size()) return new ArrayList<>();
		return list.subList(start, start+size);
	}
	
	
	
	// To get a particular messsage...
	public Message getMessage(long id) {
		
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("Message with id:"+id+" Not found");
		}
		return messages.get(id);		
	}
	
	public Message addMessage(Message message) {
		
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) throws Throwable {
		
		/*if(id==0) {
			throw new Throwable("Un known exception");
		}*/
		int i = 10/0;
		
		return messages.remove(id);
	}

}