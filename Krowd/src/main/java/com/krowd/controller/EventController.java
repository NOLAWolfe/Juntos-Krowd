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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krowd.beans.Events;
import com.krowd.service.EventService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/event")
public class EventController {
	@Autowired
	private EventService eventService;
	
//	Events u1 = new Events(200,"The","Greatest","ImTheMan","WhoAmI23@gmail.com",100,"ImBetterThanTheBest","BetterThanYou.url");
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Events>> getAllEvents(){
		return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<Events> getEventById(@PathVariable int id){
		Events u = eventService.getEventById(id);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	
	@GetMapping(value="/user/{userid}")
	@ResponseBody
	public ResponseEntity<List<Events>> getEventByUserId(@PathVariable int userid) {
		List<Events> u = eventService.getEventByUserId(userid);
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
	}
	
	@PostMapping(value="/add")
	@ResponseBody
	public ResponseEntity<String> createEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		System.out.println(event);
		try {
			eventService.createEvent(event);
			resp = new ResponseEntity<>("Event Created!", HttpStatus.OK);
			
		} catch (Exception e) {
			resp = new ResponseEntity<>("No Event Created, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value="/update")
	@ResponseBody
	public ResponseEntity<String> updateEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		try {
			eventService.updateEvents(event);
			resp = new ResponseEntity<>("Event Updated!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Event Not Updated, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value="/delete")
	@ResponseBody
	public ResponseEntity<String> deleteEvent(@RequestBody Events event){
		ResponseEntity<String> resp = null;
		try {
			eventService.deleteEvents(event);
			resp = new ResponseEntity<>("Event Deleted!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Event Not Deleted, Try Again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	
	
	
	
}
