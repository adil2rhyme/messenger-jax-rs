package org.adil.backend.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.adil.backend.messenger.database.DatabaseClass;
import org.adil.backend.messenger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello JAX-RS", "Adil"));
		messages.put(2L, new Message(2L, "Hello Jersey", "aadil"));
	}

	public List<Message> getAllMessages() {

		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesByYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar calender = Calendar.getInstance();
		for(Message message : messages.values()) {
			calender.setTime(message.getCreatedDate());
			if(calender.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}

	public Message addMessage(Message msg) {
		msg.setMessageId(messages.size() + 1L);
		messages.put(msg.getMessageId(), msg);
		return msg;
	}

	public Message updateMessage(Message msg) {
		if (msg.getMessageId() <= 0) {
			return null;
		}
		messages.put(msg.getMessageId(), msg);
		return msg;
	}

	public Message deleteMessage(Long id) {
		return messages.remove(id);
	}

}
