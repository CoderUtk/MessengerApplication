package org.utkarsh.messenger.resources;

import java.net.URI;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.utkarsh.messenger.exception.NoDataFoundException;
import org.utkarsh.messenger.filters.MessageFilter;
import org.utkarsh.messenger.model.Message;
import org.utkarsh.messenger.services.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilter filter) {
        if (filter.getYear() > 0) {
            return messageService.getMessagesForYear(filter.getYear());
        }
        if (filter.getStart() > 0 && filter.getSize() > 0) {
            return messageService.getAllMessagesPaginated(filter.getStart(), filter.getSize());
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}") // One can also use regex -- make a note
    public Message getMessage(@BeanParam MessageFilter messageFilter) {
        Message message = messageService.getMessage(messageFilter.getId());
        if (message == null) {
            throw new NoDataFoundException("No Data Found for message id " + messageFilter.getId());
        }
        return message;
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        //return Response.status(Response.Status.CREATED).
        //        entity(messageService.addMessage(message)).
        //        build();
        Message newMessage = messageService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(newMessage.getId() + "").build();
        return Response.created(uri).
                entity(newMessage).
                build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@BeanParam MessageFilter filter, Message message) {
        message.setId(filter.getId());
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@BeanParam MessageFilter filter, long id) {
        messageService.removeMessage(filter.getId());
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }
}
