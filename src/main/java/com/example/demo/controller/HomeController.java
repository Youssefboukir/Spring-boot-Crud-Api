package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Todo;
import com.example.demo.service.TodoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {
	@Autowired
	private TodoService todoservice;
	
	@GetMapping("/listmatch")
	public ArrayList<Todo> getTodos(){
		return todoservice.getAll();
	}
	
	@PostMapping("/Addmatch")
	public Todo create(Todo t) {
		todoservice.saveOrUpdate(t);
		return t;
	}
	
	@PutMapping("/updatematch")
	public void update(Todo t) {
		todoservice.saveOrUpdate(t);
	}
	
	@GetMapping("/getonemath/{id}")
	public Todo getTodo(@PathVariable("id") int id){
	return todoservice.getTodo(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		todoservice.deleteByid(id);
	}
	
}
