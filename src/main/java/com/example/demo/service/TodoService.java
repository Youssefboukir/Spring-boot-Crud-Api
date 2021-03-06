package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Todo;

@Service
public class TodoService {
	
	 @Autowired
	 private com.example.demo.repo.TodoReposotry todorepo;
	 
	 public ArrayList<Todo> getAll() {
		 ArrayList<Todo> todos=new ArrayList<>();
		  todorepo.findAll().forEach(todo->todos.add(todo));
		 return todos;
	 }
	 public void saveOrUpdate(Todo t) {
		 todorepo.save(t);
	 }
	 public Todo getTodo(int id) {
		 return todorepo.findById(id).get();
	 }
	 public void deleteByid(int id) {
		 todorepo.deleteById(id);
	 }

}
