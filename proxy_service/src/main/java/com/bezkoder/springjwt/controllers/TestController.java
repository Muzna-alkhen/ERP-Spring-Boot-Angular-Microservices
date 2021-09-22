package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.mq.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


	@Autowired
	private Queue queue ;

	@Autowired
	private Queue Tqueue ;

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("message/{message}")
	public ResponseEntity<String> publish(@PathVariable("message") final String message){
		 Node node = new Node("1",message);
		jmsTemplate.convertAndSend(queue, node);
		return new ResponseEntity(message, HttpStatus.OK);
	}



	@GetMapping("test/{message}")
	public ResponseEntity<String> test(@PathVariable("message") final String message){
		Node node = new Node("1",message);
		jmsTemplate.convertAndSend(Tqueue, node);
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}




}
