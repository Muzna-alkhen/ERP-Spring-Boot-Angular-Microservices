package com.programming.techie.pmservice;

import com.programming.techie.pmservice.mq.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
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



	@GetMapping("/test/{message}")
	public ResponseEntity<String> test(@PathVariable("message") final String message){

		return new ResponseEntity(message+"!!!!!!!", HttpStatus.OK);
	}



}
