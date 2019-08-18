package org.utkarsh.messenger.resources;

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
import javax.ws.rs.core.MediaType;
import org.utkarsh.messenger.filters.CommentFilter;
import org.utkarsh.messenger.filters.MessageFilter;
import org.utkarsh.messenger.model.Comment;
import org.utkarsh.messenger.services.CommentService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@BeanParam MessageFilter messageFilter, @BeanParam CommentFilter commentFilter) {
        return commentService.getComment(messageFilter.getId(), commentFilter.getCommentId());
    }

    @POST
    public Comment addComment(@BeanParam MessageFilter messageFilter, Comment comment) {
        return commentService.addComment(messageFilter.getId(), comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@BeanParam MessageFilter messageFilter, Comment comment) {
        return commentService.updateComment(messageFilter.getId(), comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void removeComment(@BeanParam MessageFilter messageFilter, @PathParam("commentId") long commentId) {
        commentService.removeComment(messageFilter.getId(), commentId);
    }
}
