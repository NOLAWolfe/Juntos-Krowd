package com.krowd.dao;

import java.util.List;

import com.krowd.beans.Comments;

/*
 * The interface for the CommentDAO. These methods will be implemented in the
 * CommentDAOImpl. 
 */
public interface CommentDAO {
	
	public List<Comments> getAllComments();
	public Comments getCommentById(int comment_Id);
	List<Comments> getCommentsByUserId(int user_Id);
	List<Comments> getCommentsByEventId(int event_Id);
	public void deleteComment(Comments comments);
	public void updateComment(Comments comments);
	public void createComment(Comments comments);


}
