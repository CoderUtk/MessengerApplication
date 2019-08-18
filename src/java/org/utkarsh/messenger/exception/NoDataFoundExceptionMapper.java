package org.utkarsh.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.utkarsh.messenger.model.ErrorMessage;

@Provider
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException> {

    @Override
    public Response toResponse(NoDataFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(404, e.getMessage(), "nothing");
        return Response.status(Response.Status.NOT_FOUND).
                entity(errorMessage).
                build();
    }
}
