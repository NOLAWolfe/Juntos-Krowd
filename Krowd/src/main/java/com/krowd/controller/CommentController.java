package com.krowd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krowd.beans.Comments;
import com.krowd.beans.Events;
import com.krowd.beans.Users;
import com.krowd.service.CommentService;
import com.krowd.service.EventService;
import com.krowd.service.EventServiceImpl;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
//	comments u1 = new comments(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Comments>> getAllcomments(){
		return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Comments> getcommentById(@PathVariable int id){
		Comments u = commentService.getCommentById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	@GetMapping(value="/user/{id}")
	@ResponseBody
	public ResponseEntity<List<Comments>> getcommentsByUserId(@PathVariable int id){
		List<Comments> u = commentService.getCommentsByUserId(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	@GetMapping(value="/event/{id}")
	@ResponseBody
	public ResponseEntity<List<Comments>> getcommentsByEventId(@PathVariable int id){
		List<Comments> u = commentService.getCommentsByEventId(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value="/add/(id)")
	@ResponseBody
	public ResponseEntity<String> addcomment(@PathVariable int id, @RequestBody Comments comment){
		ResponseEntity<String> resp = null;
		try {
			
			commentService.createComment(comment);
			resp = new ResponseEntity<>("comment Created!", HttpStatus.OK);
			
		} catch (Exception e) {
			resp = new ResponseEntity<>("No comment Created, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	@PutMapping(value="/update/{id}")
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Users user){
		ResponseEntity<String> resp = null;
		try {
			
			
			resp = new ResponseEntity<>("User Updated!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("User Not Updated, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
