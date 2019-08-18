package org.utkarsh.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Produces(MediaType.TEXT_PLAIN)
public class DemoResource {

    @Path("/injections1")
    @GET
    public String getParams(
            @MatrixParam("param") String matrixParam,
            @HeaderParam("sessionID") String header,
            @CookieParam("name") String cookie) {
        return "Matrix param = " + matrixParam + " " + "Header Param : " + header + " Cookie = " + cookie;
    }

    @Path("/injections2")
    @GET
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        return uriInfo.getAbsolutePath() + "________" + httpHeaders.getCookies();
    }
}
