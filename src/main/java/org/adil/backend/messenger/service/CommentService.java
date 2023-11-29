package org.adil.backend.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adil.backend.messenger.database.DatabaseClass;
import org.adil.backend.messenger.model.Comment;
import org.adil.backend.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		Comment comment = messages.get(messageId).getComments().get(commentId);
		return comment;
	}

	public Comment addComment(long messageId, Comment comment) {

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setCommentId(comments.size() + 1);
		comments.put(comment.getCommentId(), comment);

		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getCommentId() <= 0) {
			return null;
		}
		comments.put(comment.getCommentId(), comment);
		return comment;
	}

	public Comment deleteComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
