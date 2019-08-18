package org.utkarsh.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.utkarsh.messenger.database.Database;
import org.utkarsh.messenger.model.Comment;
import org.utkarsh.messenger.model.Message;

public class CommentService {

    private final Map<Long, Message> messages = Database.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(Long messageId, Long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public void removeComment(Long messageId, Long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.remove(commentId);
    }
}
