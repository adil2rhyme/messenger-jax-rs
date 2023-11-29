package org.adil.backend.messenger.resources;

import java.util.List;

import org.adil.backend.messenger.model.Message;
import org.adil.backend.messenger.resources.beans.MessageFilterBean;
import org.adil.backend.messenger.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService msg = new MessageService();

	@GET
	public List<Message> getAllMessage(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear() > 0) {
			return msg.getAllMessagesByYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return msg.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return msg.getAllMessages();

	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long id) {
		return msg.getMessage(id);
	}

	@POST
	public Message addMessage(Message message) {
		return msg.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long id, Message message) {
		message.setMessageId(id);
		return msg.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") Long id) {
		return msg.deleteMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
