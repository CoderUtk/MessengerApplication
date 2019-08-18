package org.utkarsh.messenger.filters;

import javax.ws.rs.PathParam;

public class CommentFilter {

    @PathParam("commentId")
    private long commentId;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

}
