package com.krowd.service;

import java.util.List;

import com.krowd.beans.Comments;

/*
 * This is an interface that contains methods for the services for Comments.
 */
public interface CommentService {
	
	List<Comments> getAllComments();
	public Comments getCommentById(int comment_Id);
	List<Comments> getCommentsByUserId(int user_Id);
	List<Comments> getCommentsByEventId(int event_Id);
	public void deleteComment(Comments comments);
	public void updateComment(Comments comments);
	public void createComment(Comments comments);
//	public void updateFollow(Users user, Users user2);
}
