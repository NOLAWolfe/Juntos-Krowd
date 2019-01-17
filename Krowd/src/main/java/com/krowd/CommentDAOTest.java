package com.krowd;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.krowd.beans.Comments;
import com.krowd.dao.CommentDAO;
import com.krowd.dao.CommentDAOImpl;

/*
 * These are tests that are to test out the methods of the CommentDAO.
 */

class CommentDAOTest {

	private static CommentDAO cd;
	private static Comments c;
	private static Comments nc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cd = new CommentDAOImpl();
		c = new Comments();
	}
	
	@AfterEach void setUpAfterClass() throws Exception{
		if (cd.getCommentById(1001) != null) {
			cd.deleteComment(c);
		}
	}

	@Test
	void testDeleteComment() {
		cd.deleteComment(c);
		assertNull(cd.getCommentById(1001));
	}

	@Test
	void testUpdateComment() {
		cd.createComment(c);
		nc = new Comments();
		cd.updateComment(nc);
		assertEquals("Updated", cd.getCommentById(1001).getData());
		
	}

	@Test
	void testCreateComment() {
		cd.createComment(c);
		assertEquals("Here is a test comment", cd.getCommentById(1001).getData());
	}

	@Test
	void testGetCommentById() {
		assertEquals("Krowd always hosting the best events", cd.getCommentById(8).getData());
	}

	@Test
	void testGetAllComments() {
		assertNotNull(cd.getAllComments());
	}

	@Test
	void testGetCommentsByUserId() {
		assertEquals("Best Event Ever", cd.getCommentsByUserId(16).get(1).getData());
	}

	@Test
	void testGetCommentsByEventId() {
		assertNotNull(cd.getCommentsByEventId(1));
	}

}
